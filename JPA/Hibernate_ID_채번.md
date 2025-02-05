Hibernate 에서 지원하는 Id 채번 방식
===

## JPA에서 지원하는 Id Generator 전략
- TABLE
  - DB Table를 활용한 Id 채번 전략
- SEQUENCE
  - DB Sequence를 활용한 채번 전략
- IDENTITY
  - DB Id Column을 지정하는 전략
- UUID
  - RFC 4122에 따른 UUID 생성 전략
- AUTO
  - Hibernate가 자동으로 id를 채번
---

### AUTO
Auto 전략은 별도의 채번 전략이 있는게 아닌 Generator 에서 지정한 전략에 따라서 Sequence, Identity, UUID 중 하나를 구현.
- Generator 에서 Increment 지정 
  - increment 전략 사용
- Id 컬럼 타입을 UUID 지정
  - UUID 전략 사용
- 그 외는 Sequence 전략 사용

Auto의 경우 하이버네이트 내부 정책에 따라 달라지므로 UUID 외에는 사용하지 않는게 안전하다고 함.

UUID 예제
```java
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID studentId;
}

```

---

### Identity
```java
@Entity
@Table(name = "student")
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long studentId;
}
```
- 일반적으로 가장 많이 사용하는 방식
- MySQL 에서 auto_increment 를 컬럼에 지정해 테이블을 생성하고 Identity 명시
- 해당 전략을 사용하면 하이버네이트의 batch insert 즉 벌크 삽입 사용이 불가

> batch insert 는 대량의 INSERT 쿼리를 실행하는 기능인데, auto_increment 전략이 사용되는 Identity 경우 DB에 insert 해야 Id가 채번된다.
> 또한, 하이버네이트는 트랜잭션 마지막에 flush해 DB에 Insert하는 쓰기 지연 방시을 사용한다. 하지만 batch insert는 여러 트랜잭션이 들어오는 것을 대비 ID 값을 먼저 알고 있어야하나 이러한 방식이 불가능하다. 


---
### Sequence
```java
@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
	@GenericGenerator(
		name = "sequence-generator",
		strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		parameters = {
			@Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = "user_sequence"),
			@Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
			@Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = SequenceStyleGenerator.OPT_PARAM, value = "pooled")
		}
	)
	private Long studentId;
}
```
- DB에서 Sequence 방식 제공할 때 사용하며, 지원하지 않는 경우 Table 전략으로 변경됨
- Oracle DB에서 주로 사용
- generator 를 GenericGenerator 를 통해 정의하며, 어떤 전략을 사용하는지 결정
- INCREMENT_PARAM과 OPT_PARAM은 하이버네이트가 Id 생성에 대한 성능 향상을 위해 메모리에 id를 미리 채번

---
### Table
```java
@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(
		name = "table-generator",
		table = "hibernate-id-table",
		pkColumnName = "student_id",
		valueColumnName = "student_id",
		initialValue = 1,
		allocationSize = 1
	)
	private Long studentId;
}
```
- Sequence와 유사하며 특정 Table를 이용햐 id를 채번
- TableGenerator를 통해 쉽게 생성 가능
- allocationSize를 통해 메모리에 몇 개의 id를 채번시킬 것인지 결정 

---
#### Optimizer
- 하이버네이트에서 id 채번에 대한 성능적인 부분을 보완하고자 메모리에 미리 채번하는 기술
- increment size 가 1인 경우 optimizer 를 사용하지 않음
- hibernate.id.optimizer.pooled.preferred 를 지정하였으면 해당 전략을 사용
- 그 외에는 pooled optimizer 사용
종류
- NONE
- HILO
- LEGACY_HILO
- POOLED
  - 기본으로 사용되는 방식
  - hilo 알고리즘 기반으로 id 기준을 hi로 지정
- POOLED_LO
  - pooled와 유사하지만 id 기준을 lo로 지정
- POOLED_LOTL

---

### 참고
https://huisam.tistory.com/entry/spring-jpa-hibernate-id
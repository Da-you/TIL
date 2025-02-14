Map 인터페이스
==

- 키와 값의 쌍으로 연관지어 이루어진 데이터의 집합
- 값은 중복 저장이 가능하나 키는 해당 Map에서 고유해야 한다.
    - 기존 데이터와 중복된 키와 값을 저장하면 기존값은 사라지고 최신 값만 남는다.
- 저장 순서가 유지되지 않는다.

종류

- HashMap 동기화x
- LinkedHashMap 순서O
- HashTable 동기화 O, 가급적 사용x
- TreeMap 정렬

메서드

| 메서드                                                                                        | 반환 타입                  | 설명                                                                          |
|--------------------------------------------------------------------------------------------|------------------------|-----------------------------------------------------------------------------|
| `put(K key, V value)`                                                                      | `V`                    | 키 `key`에 값을 `value`를 추가 (이미 존재하면 덮어쓰기)                                      |
| `putAll(Map<? extends K, ? extends V> m)`                                                  | `void`                 | 주어진 `Map`의 모든 엔트리를 현재 맵에 추가                                                 |
| `putIfAbsent(K key, V value)`                                                              | `V`                    | 키가 없을 경우에만 `value`를 추가하고, 기존 값이 있으면 변경하지 않음                                 |
| `get(Object key)`                                                                          | `V`                    | 지정된 키 `key`의 값을 반환 (없으면 `null`)                                             |
| `getOrDefault(Object key, V defaultValue)`                                                 | `V`                    | 키가 존재하면 해당 값을 반환, 없으면 `defaultValue` 반환                                     |
| `containsKey(Object key)`                                                                  | `boolean`              | 지정된 키가 존재하는지 여부 확인                                                          |
| `containsValue(Object value)`                                                              | `boolean`              | 특정 값이 존재하는지 여부 확인                                                           |
| `remove(Object key)`                                                                       | `V`                    | 지정된 키 `key`의 엔트리를 삭제하고 삭제된 값을 반환                                            |
| `remove(Object key, Object value)`                                                         | `boolean`              | 키가 `key`, 값이 `value`인 엔트리를 삭제 (존재하면 `true`)                                 |
| `replace(K key, V value)`                                                                  | `V`                    | 키가 존재하면 값을 `value`로 변경하고 이전 값을 반환                                           |
| `replace(K key, V oldValue, V newValue)`                                                   | `boolean`              | 키가 `key`이고, 값이 `oldValue`이면 `newValue`로 변경                                  |
| `clear()`                                                                                  | `void`                 | 모든 엔트리를 삭제                                                                  |
| `size()`                                                                                   | `int`                  | 맵에 저장된 엔트리 개수 반환                                                            |
| `isEmpty()`                                                                                | `boolean`              | 맵이 비어 있는지 여부 반환                                                             |
| `keySet()`                                                                                 | `Set<K>`               | 모든 키를 포함하는 `Set`을 반환                                                        |
| `values()`                                                                                 | `Collection<V>`        | 모든 값을 포함하는 `Collection`을 반환                                                 |
| `entrySet()`                                                                               | `Set<Map.Entry<K, V>>` | 모든 키-값 쌍을 `Set` 형태로 반환                                                      |
| `forEach(BiConsumer<? super K, ? super V> action)`                                         | `void`                 | 모든 키-값 쌍에 대해 `action`을 수행                                                   |
| `compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)`          | `V`                    | 키 `key`에 대해 새로운 값 계산 후 저장                                                   |
| `computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)`                 | `V`                    | 키가 없으면 새 값을 계산 후 저장                                                         |
| `computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)` | `V`                    | 키가 존재하면 새로운 값을 계산 후                                                      저장 |
| `merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)`   | `V`                    | 키가 없으면 추가, 있으면                              `remappingFunction`을 적용하여 병합    |

> Map 인터페이스는 값은 중복을 허용하기에 컬렉션 타입으로 반환하고 키는 중복을 허용하지 않기에 Set 타입으로 반환하는 특징이 있다.
## Map.Entry 인터페이스

- Map 인터페이스 안에 있는 내부 인터페이스
- Map 에 저장되는 키-값 쌍의 Node 내부 클래스로 구성
- Map 자료구조를 보다 객체지향적인 설계를 하도록 유도

메서드

- equals() : 동일한 Entry 인지 비교
- getKey() : Entry 의 key 객체를 반환
- getValue() : Entry 의 value 객체를 반환
- hashCode() : Entry 의 해시코드 반환
- setValue() : Entry 의 value 객체를 지정된 객체로 변환

---

## HashMap 클래스

- HashTable 을 보완한 컬렉션
- 배열과 연결이 결합된 Hashing 형태로 키와 값을 묶어 하나의 데이터로 저장
- 중복을 허용하지 않으며 순서를 보장하지 않음
- 키와 값으로 null 허용
- 추가, 삭제, 검색에 용이
- HashMap 은 비동기로 동작하기에 멀티 스레드 환경에 어울리지 않음(ConcurrentHashMap 권장)

### HashTable 클래스
- 키를 특정 해시 함수로 해싱한 결과를 배열의 인덱스로 사용해 값을 찾는 방식
- null 사용 X
- 가급적 사용하지 않음
--- 
## LinkedHashMap
- HashMap 을 상속하지만 Entry 들이 연결 리스트를 구성해 데이터 순서 보장
  - LinkedHashMap 은 들어온 순서대로 순서를 가짐

---
## TreeMap

- 이진 검색 트리 형태로 키와 값 쌍으로 이뤄진 데이터르 저장 (TreeSet 과 같은 원리)
- SortedMap 인터페이스를 구현하고 있어 키 기준으로 정렬
- 정렬 순서로 키/값 쌍을 저장해 빠른 검색(범위 검색) 가능
  - 키와 값 저장과 동시에 정렬이 진행되어 저장이 느림
  - 정렬 순서는 숫자 -> 알파벳 대문자 -> 소문자 -> 한글

--- 
## Properties

- Properties(String, String) 형태로 저장되는 단순 구조
- 주로 애플리케이션의 환경 설정과 관련 속성 파일인 .properties 설정에 사용
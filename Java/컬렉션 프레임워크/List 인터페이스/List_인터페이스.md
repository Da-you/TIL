List 인터페이스
==

- 순서가 있는 저장 공간으로 저장 순서가 유지되는 컬렉션을 구현할 때 사용
- 동일한 요소의 중복 저장 허용
- 배열과 마찬가지로 index로 요소에 접근
    - 배열과의 차이는 리스트의 경우 자료형 크기가 조정이 아닌 데이터 양에 따라 동적으로 변한다.(가변)
    - 요소 사이에 빈공간을 허용하지 않아 배열 이동이 발생

## 종류

- ArrayList
- LinkedList
- Vector
- Stack

## 메서드

| 메서드                                            | 반환 타입             | 설명                                                  |
|------------------------------------------------|-------------------|-----------------------------------------------------|
| `add(int index, E element)`                    | `void`            | 리스트의 특정 위치(`index`)에 요소 `element`를 삽입               |
| `addAll(int index, Collection<? extends E> c)` | `boolean`         | 특정 위치(`index`)에 주어진 컬렉션 `c`의 모든 요소를 삽입              |
| `get(int index)`                               | `E`               | 리스트에서 특정 위치(`index`)의 요소를 반환                        |
| `indexOf(Object o)`                            | `int`             | 리스트에서 특정 요소 `o`의 첫 번째 위치를 반환 (없으면 `-1`)             |
| `lastIndexOf(Object o)`                        | `int`             | 리스트에서 특정 요소 `o`의 마지막 위치를 반환 (없으면 `-1`)              |
| `listIterator()`                               | `ListIterator<E>` | 리스트를 양방향으로 순회할 수 있는 `ListIterator` 객체 반환            |
| `listIterator(int index)`                      | `ListIterator<E>` | 특정 위치(`index`)에서부터 리스트를 순회할 `ListIterator` 객체 반환    |
| `remove(int index)`                            | `E`               | 리스트에서 특정 위치(`index`)의 요소를 제거하고 반환                   |
| `set(int index, E element)`                    | `E`               | 리스트에서 특정 위치(`index`)의 요소를 `element`로 변경             |
| `subList(int fromIndex, int toIndex)`          | `List<E>`         | 리스트의 특정 범위(`fromIndex`부터 `toIndex-1`까지)를 부분 리스트로 반환 |
| `sort(Comparator<? super E> c)`                | `void`            | 주어진 비교 기준(`Comparator`)을 사용하여 리스트 정렬                |

---

### ArrayList 클래스

- 배열을 이용해 만든 리스트
- 데이터의 저장순서가 유지되고 중복 허용
- 데이터 크기에 따라 저장 공간 동적 할당
- 단방향 포인터 구조로 자료에 대한 순차적 접근에 강점이 있어 조회가 빠름
    - 삽입 / 삭제가 느림(순차적으로 추가/삭제는 빠르다.) : 앞 , 중간에 데이터 변경 발생 시 배열의 요소돌을 이동하기 때문이다.

#### 시간 복잡도

- 데이터 추가/삭제 시
    - 마지막 : O(1)
    - 앞, 중간 : O(N)
- 인덱스 조회 : O(1)
- 데이터 검색 : O(N)

---

### LinkedList

- 노드(객체)를 연결해 리스트 처럼 만든 컬렉션(배열이 아님)
- 데이터의 중간 삽입, 삭제가 많은 경우 빠른 성능 보장
- 임의의 요소에 대한 접근 성능은 좋지 않다.
- 자바의 LinkedList는 양방향 포인터 구조
    - 리스트 이외에도, 스택, 큐, 트리등의 자료구조의 근간

---

### Vector

- ArrayList 구형 버전(내부 구성 비슷)
- 동기화되어 있어 스레드 안전

---

### Stack

- 후입선출 자료구조
    - 마지막에 들어온 원소가 처음으로 나감
- 들어올때는 push, 나갈떄는 pop 용어를 사용
- Vector를 상속

---

## 출처

https://inpa.tistory.com/entry/JCF-%F0%9F%A7%B1-Collections-Framework-%EC%A2%85%EB%A5%98-%EC%B4%9D%EC%A0%95%EB%A6%AC#java_collection_framework

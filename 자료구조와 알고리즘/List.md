# List

- 선형적인 자료구조
- 순서가 존재
- array List, Linked List가 있음

## Array List

 - 배열기반의 리스트
   : 랜덤 엑세스 방식으로 리스트에 데이터가 몇개가 있든 인덱스만 알고있다면 항상 동일한 시간을 사용하여 데이터 접근 가능

  - 메모리 공간을 연속적으로 사용
    : 컴퓨터의 실제 물리적인 공간에서도 연속적인 공간을 사용해 연산이 쉬운 구조

  - 데이터의 삽입, 삭제시 O(n)의 시간이 소요
    : 데이터를 삽입, 삭제할 경우 데이터를 옮겨야 하기 때문에 시간이 오래걸림 

## Linked List

- 노드들이 연결되어 있는 리스트(노드는 데이터를 저장하는 공간과 다음 노드를 가리키는 포인터인 next pointer 로 구성)
    : 랜덤 엑세스 방식으로 리스트에 데이터가 몇개가 있든 인덱스만 알고있다면 항상 동일한 시간을 사용하여 데이터 접근 가능
    
    - 메모리 공간을 연속적으로 사용하지 않음
        : 컴퓨터의 실제 물리적인 공간에서도 연속적인 공간을 사용하지 않아 연산이 어려운 구조
    
    - 데이터의 삽입, 삭제시 O(1)의 시간이 소요
        : 데이터를 삽입, 삭제할 경우 데이터를 옮기지 않아도 되기 때문에 시간이 빠름

- 장점 
 : 배열의 복사나 재할당 없이 데이터를 삽입, 삭제할 수 있음, 유연한 공간 

- 단점
 : 랜덤 엑세스가 안되기에 데이터 접근에시간이 오래걸림, 포인터를 위한 메모리 공간이 추가로 필요함
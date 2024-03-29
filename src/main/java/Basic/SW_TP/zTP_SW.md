# TwoPointer 와 SlidingWindow
- 연속된 값들을 이용하여 목표값을 찾아나가는 문제이다.
  - 연속된 값들을 이용하는 풀어나가는 문제만 적용가능하다.
- 시간복잡도 O(n)을 갖는 알고리즘이다.
- 차이점
    - TP : 특정 범위가 동적이다.
    - SW : 특정 범위가 고정이다.


## TwoPointer

---
- 연속적인 Data가 주어졌을 때 두개의 포인터를 이용하여 범위를 정해 목표값인지 검증하는 알고리즘
- 문제 조건
    1. 주어진 값들을 그대로 활용할 때.
    2. 정렬을 통하여 연속성을 추가해 줄 수 있는 경우.


### had the Problem

- 주의사항 : while 종료조건
    - while(endPointer <len) (부분 합을 구할 때.) 
    - 이 경우  1 3 인 배열의 값들이 들어있는 곳에서 목표값이 3일 때 1을 더하고 3을 더하고 while문을 조건을 체크할 때 종료가 된다.
    - 그러므로 if 문 중간에 else if(e>len-1) break를 처리해야 인덱스 범위 초과가 안나고 적절히 답을 구할 수 있다. 

    
💡 TP로 풀어내지 못하면 고려해볼 것은 완전탐색,백트래킹으로 주어진 입력범위가 만이 넘어간다면 반드시 TLE가 난다.

### [TwoPointer Problem](./TwoPointer/zTwoPointer.md)

## SlidingWindow

---
- TP처럼 범위가 동적이지 않고 일정한 크기를 갖는 범위내에서 목표값을 찾는 알고리즘
- 문제 조건
    1. 데이터 크기와 값이 주어지는 동시에 특정 범위가 주어지고 그 범위 내 연산처리가 이루어지도록 요구하는 경우. 
- **자됴구조 : Dequeue**
    - 인덱스 시작 0을 가장 끝 범위라고 생각한다.
    - 고정된 범위는 가장 앞에 있는 dpFirst를 이용하여 주어진 범위안 인덱스인지 판단한고 pop한다.
    - 해당 값이 다른 값을 대체 할 수 있는 조건에 만족한다면 LastPop을 하고 해당 값을 삽입한다.

### [SlidingWindow Problem](./SlidingWindow/zSlidingWindow.md)


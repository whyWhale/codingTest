## SlidingWindow

[최솟값 찾기](#최솟값-찾기)
[광고 삽입](#광고-삽입)



### 최솟값 찾기

---
**핵심**
- 최솟값을 찾기 위해 구간의 길이만큼 찾은 후 구간의 길이가 넘어가면 왼쪽것을 당겨야한다.
- 이 원리를 Dequeue 안에 인덱스를 저장한뒤 해당 인덱스가 길이가 넘어가면 pop()을한다.

### had the Problem
> 항상 해당 주어진 고정 길이인지 확인하고 해당 인덱스를 덱에 제거해야 한다.
만약 해당 최솟값보다 더 작은 수가 올때에는 하나만 빼는것이 아닌 범위 안에서 뺄수 있는데로 최대한 최솟값을 갱신한다.
> 
<br>


### 광고 삽입

---
**핵심**
-  시간 초 단위 변환
- String.format 을 이용한 00시 : 00분 : 00초
- 해당 길이가 되기 전까지 e++ 해당 길이(광고 시간)가 완성 되면 누적 시청자수가 최대인지 판별하고 만약 해당 길이가 고정 길이 이상이 된다면 S를 당기고 합을 줄여준다.
### had the Problem
> 누적합으로 인한 시청자수 측정.(개념 부족)
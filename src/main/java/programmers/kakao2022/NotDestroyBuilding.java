package programmers.kakao2022;

public class NotDestroyBuilding {

    /**
     hint : 누적합 문제였습니다.

     NOTE : 예시
     [1, 3, 5, 5]
     0부터 2번 인덱스까지 2만큼 피해를 주고 싶으면 fnr 문 돌려서 [-1, 1, 3, 5] 와 같이 생성
     만약 이런 입력이 k번 들어온다면 k * 배열의 크기

     NOTE : 누적합 skill
     위의 배열과 길이가 같은 값이 0으로 전부 초기화 된 배열을 만들어줍니다.
     [0, 0, 0, 0] 시작 부분에 빼려는 값을 넣고, 종료 지점보다 한 칸 뒤에 반대 부호를 가진 값을 넣는다.

     저는 0~2 인덱스 범위에 2만큼 공격을 하고 싶으니, 시작은 -2가 됨
     [-2, 0, 0, 2]
     ** 또한 종료지점보다 한 칸 뒤에 반대부호를 붙인 값을 더해주는 것을 주의. **
     위의 배열을 왼쪽부터 오른쪽으로 누적합을 하면

     [-2, -2, 0, 2] -> [-2, -2, -2, 2] -> [-2, -2, -2, 0]

     이걸을 기존 배열에 각각 원소마다 더해주면,
     [1, 3, 5, 5] + [-2, -2, -2, 0] = [-1, 1, 3, 5]
     우리가 원하는 값을 찾을 수 있다.

     "인용 https://programmers.co.kr/questions/25471 "

     카카오 테크 해설도 위와같이 나왔습니다. 아마 처음에 이걸 보는 사람은,
     아니 결국 다시 저렇게 더할거면, 기존하고 시간복잡도가 다를게 뭐가있냐?
     라고 생각하시는 분이 계실 겁니다.

     하지만, 누적합의 대단한 점은, 변화하는 값들을 계속 읽어들인 다음에 한 번에 누적합으로
     그 변화값의 결과를 낼 수 있다는 점입니다.
     즉 skill원소 하나당 O(N)의 시간 복잡도가 아닌 O(1)의 시간복잡도로 처리가 가능하다는 의미입니다.
     위의 예시는 하나만 들어서 비효율적으로 보인것이지, 데이터가 여러개있으면,
     누적합 연산을 제일 마지막에 한 번만 해주면 끝납니다.

     하지만, 카카오 테크는 여기서 더 고도의 기술을 바랍니다.
     바로 이런 누적합 방식을 2차원으로 확장하여 O(N*M)의 시간복잡도를 O(1)로 만들고 싶어합니다.
     아주 대단하신 분들입니다.

     해답은 아주 간단합니다.
     만약 4*4배열에서 (0, 0)~(2, 2)까지 n만큼의 변화를 주고싶다면,

     [n, 0, 0, -n]
     [0, 0, 0, 0]
     [0, 0, 0, 0]
     [-n, 0, 0, n]

     위와 같은 위치에 n을 배치하면 됩니다.
     위의 배열을 오른쪽으로 누적합, 아래쪽으로 누적합 또는 순서를 바꿔도,

     [n, n, n, 0]
     [n, n, n, 0]
     [n, n, n, 0]
     [0, 0, 0, 0]

     결과가 위와 같이 원하는 범위에 원하는 값만큼 변화시킬 수 있습니다.
     즉 (x1, y1) ~ (x2, y2)까지에 n만큼의 변화를 주고 싶다면,
     (x1, y1) = n, (x2+1, y1) = -n, (x1, y2+1) = -n, (x2+1, y2+1) = n 만큼의 값을 더해주면,
     원하는 부분에 원하는 변화량만큼 값을 바꿀 수 있습니다.

     한 번 5를 가지고 만들어볼까요?

     [5, 0, 0, -5]
     [0, 0, 0, 0]
     [0, 0, 0, 0]
     [-5, 0, 0, 5]

     먼저 각 행마다 왼쪽에서 오른쪽으로 각각 누적합을 해줍니다.

     [5, 5, 5, 0]
     [0, 0, 0, 0]
     [0, 0, 0, 0]
     [-5, -5, -5, 0]

     그 다음, 각 열마다 위에서 아래로 각각 누적합을 해줍니다.

     [5, 5, 5, 0]
     [5, 5, 5, 0]
     [5, 5, 5, 0]
     [0, 0, 0, 0]

     어떱니까? 원하는 결과를 얻지 않으셨습니까?
     누적합을 진행하기 전에 하는 표식은 중복이 되도 전체적인 결과는 동일합니다.
     이런 특성을 이용해 우리는 기존에
     O(KNM)이 걸렸던 시간 복잡도를 O(K+N*M)의 시간복잡도로 엄청나게 단축이 가능해졌습니다.
     skill하나를 가져오는데 O(1)이 걸리고 그 개수가 K만큼 존재하므로

     O(K)가 먼저 성립이됩니다. 또한 마지막에 누적합을 하기 위해서는 전체배열을 접근해야하므로
     O(NM)이 그 뒤에 추가로 더해집니다.
     최종적으로 O(K+NM)의 시간복잡도로 이 문제를 클리어 할 수 있습니다.

     https://tech.kakao.com/2022/01/14/2022-kakao-recruitment-round-1/
     또한 위의 카카오 테크 공식 사이트에도 마찬가지인 해설이 올라가있으니, 참고하시길 바랍니다.

     이 문제를 풀다가 저처럼 의문을 가지는 부분이 있을겁니다.
     굳이 왜 기존 board배열에 변화값을 가감하지 않고
     0으로만 이루어진 보드를 새로 선언하여, 그 새로운 보드에 변화값을 가감하고,
     누적합 후에 나중에 그 두 값들을 합치는가 입니다.


     BUG 주의!
     단순히 생각하면, 기존보드에 다가 변화량을 가감하여 누적합 연산을 해도 문제가 없을 것 같이 보이지만,
     전혀 그렇지 않습니다.
     일단 기존 보드의 배열은 누적합을 하였을 때, 변화량이 기록되는 값들이 아닙니다.
     우리는 좌측상단에 n 우측상단+1에 -n, 좌측하단+1에 -n, 우측하단 +1에 n의 값을 표시한 후에,
     누적합을 할경우 원하는 범위만큼 변화량 값이 표시되도록 할 수 있었지만,
     기존의 데이터의 경우는 이미 누적합을 하고 나와 나온 표시 값이라고 보는 것이 이해하기 쉬울겁니다.
     즉 누적합을 하기 전의 표식이 아닌, 아예 누적합을 하고 나온 값들 이라는 것이죠,
     그렇기 때문에, 이 상태에서 다른 표식하고 같이 누적합을 하게 되면, 전혀 엉뚱한 값이 나오게 됩니다.
     이런 상황을 막기 위해, 우리는 0으로만 이루어진 새로운 보드를 만드는 것입니다.

     */


    static int n, m;
    static int b[][];

    public int solution(int[][] board, int[][] skill) {
        n = board.length;
        m = board[0].length;
        b = new int[n + 1][m + 1];
        for (int[] behavior : skill) {
            int type = behavior[0];
            int r1 = behavior[1];
            int c1 = behavior[2];
            int r2 = behavior[3];
            int c2 = behavior[4];
            int degree = type == 1 ? -behavior[5] : behavior[5];
            /*
             * 2억 5천번 시간초과
             *  code
             * for (int i = r1; i <=r2 ; i++) {
                b[r1][c1] += degree;
                b[r1][c2 + 1] -= degree;
                }
             */
            b[r1][c1] += degree;
            b[r1][c2 + 1] -= degree;
            b[r2 + 1][c1] -= degree;
            b[r2 + 1][c2 + 1] += degree;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j != 0) {
                    b[i][j] += b[i][j - 1]; // 열 누적합
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    b[i][j] += b[i - 1][j]; // 행 누적합
                }
                // bug : 변환량을 원본 배열에 기록을 하면 변화량이 아니여도 원본 배열에는 0보다 큰 값이면 변화량이라고 환산하여 누적하므로 따로 계산이 필요하다.
                if (board[i][j] + b[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}

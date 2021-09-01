package tues_thurs_sat._20210826;

import java.util.Arrays;

public class eatTheGround {
    public static void main(String[] args) {
        eatTheGround eatTheGround = new eatTheGround();
        int land[][]={
                {1,2,3,5},{5,6,7,8},{4,3,2,1}
        };
        eatTheGround.solution(land);
    }
    int solution(int[][] land) {
        int answer = 0;
        int dp[][]=new int[land.length][4];
        dp[0][0]=land[0][0];
        dp[0][1]=land[0][1];
        dp[0][2]=land[0][2];
        dp[0][3]=land[0][3];
        for (int i = 1; i <dp.length ; i++) {
            int[] sub = dp[i-1];
            dp[i][0]=land[i][0]+Math.max(Math.max(sub[1],sub[2]),sub[3]);
            dp[i][1]=land[i][1]+Math.max(Math.max(sub[0],sub[2]),sub[3]);
            dp[i][2]=land[i][2]+Math.max(Math.max(sub[0],sub[1]),sub[3]);
            dp[i][3]=land[i][3]+Math.max(Math.max(sub[0],sub[1]),sub[2]);
        }

        int[] lastRow = dp[land.length-1];
        answer = Arrays.stream(lastRow).reduce(Integer::max).orElseThrow(RuntimeException::new);
        return answer;
    }
}

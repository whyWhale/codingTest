package tues_thurs_sat._202104._20200401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(st.nextToken());
        while (T-->0)
        {
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int arr[][]=new int[2][n+1];
            for (int i = 0; i < 2; i++) {
                st=new StringTokenizer(br.readLine());
                for (int j = 1; j <=n ; j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            int dp[][]=new int[2][n+1];
            dp[0][1]=arr[0][1];
            dp[1][1]=arr[1][1];
            for (int i = 2; i <=n; i++) {
                dp[0][i]=arr[0][i]+Math.max(dp[1][i-1],dp[1][i-2]);
                dp[1][i]=arr[1][i]+Math.max(dp[0][i-1],dp[0][i-2]);
            }
            sb.append(Math.max(dp[0][n],dp[1][n])+"\n");
        }
        System.out.println(sb);
    }
}

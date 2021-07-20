package Basic.Sorting.SortingPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://www.acmicpc.net/problem/18310
public class Anteana {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if(n%2==0)
        {
            int max=Math.min(arr[n/2-1],arr[n/2]);
            System.out.println(max);
        }
        else
        {
            System.out.println(arr[n/2]);
        }
    }
}

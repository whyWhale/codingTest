package oneDay_twoSol.Dyanmic.groubBysolving;

import java.util.Scanner;

public class Tiling2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d[]=new int [n+1];
        d[1]=1;
        d[2]=3;

        for (int i = 3; i <n+1 ; i++) {
            d[i]=d[i-1]+2*d[i-2];
            d[i]%=10007;
        }
        System.out.println(d[n]);

    }
}

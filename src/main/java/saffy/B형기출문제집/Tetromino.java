package saffy.B형기출문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino {
	static int n, m, max,map[][];
	static boolean v[][];
	static int dy[]={-1,1,0,0};
	static int dx[]={0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map=new int[n][m];
		v=new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer=solve();
		System.out.println(answer);
	}
	public static int solve(){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matchShape(i,j,0,0);
				rematchShape(i,j);
			}
		}

		return max;
	}
	static void rematchShape(int y,int x){
		int sum=map[y][x];
		int min=Integer.MAX_VALUE;
		int wings=4;
		for (int i = 0; i <4 ; i++) {
			int ny=dy[i]+y;
			int nx=dx[i]+x;
			if(wings<3) return;

			if(outOfRange(ny,nx)) {
				wings--;
				continue;

			}
			min=Math.min(min,map[ny][nx]);
			sum+=map[ny][nx];
		}

		if(wings==4)
			sum-=min;

		max=Math.max(max,sum);
	}
	static void matchShape(int y,int x,int depth,int sum){
		v[y][x]=true;

		if(depth==4){
			max=Math.max(max,sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny=dy[i]+y;
			int nx=dx[i]+x;
			if(outOfRange(ny,nx) || v[ny][nx]) continue;
			matchShape(ny,nx,depth+1,sum+map[ny][nx]);
			v[ny][nx]=false;
		}

		v[y][x]=false;
	}
	static boolean outOfRange(int ny,int nx){
		return ny<0 || nx<0 || ny>n-1 || nx>m-1;
	}
}

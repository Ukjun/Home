package jun;


import java.util.*;
public class Main{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int[][]dp = new int[31][31];
		for(int i=0; i<num; i++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			for(int x=0; x<31; x++) {
				for(int y=0; y<31; y++) {
					dp[x][y] = 0;
				}
			}
			for(int x=1; x<=m;x++) {
				dp[1][x] = x;
			}
			
			for(int a=2; a<=n; a++) {
				for(int b=a; b<=m; b++) {
					if(a==b) {
						dp[a][b] = 1;
						continue;
					}
					for(int c=b-1; c>=0; c--) {
						dp[a][b] += dp[b-1][c];
					}
				}
			}
			System.out.println(dp[n][m]);
		}
		scanner.close();
	}
}
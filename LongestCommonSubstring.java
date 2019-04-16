import java.util.Scanner;


public class LongestCommonSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.next();
        String Y = sc.next();
        System.out.println(LCString(X,Y));
    }
    public static String LCString(String x,String y){
        int n = x.length();
        int m = y.length();
        int [][] dp = new int[n+1][m+1];
        int a = 0;
        int max = -1;
        for(int j = m-1;j>=0;j--){
            for(int i = n-1;i>=0;i--){
                if(x.charAt(i) == y.charAt(j)) dp[i][j] = 1 + dp[i+1][j+1];
                else dp[i][j] = 0;
                if(max<dp[i][j]) {
                    max = dp[i][j];
                    a = i;
                }
            }
        }
        if(max<=0) return "";
        return x.substring(a,a+max);
    }
}
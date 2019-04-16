import java.util.*;
public class MaxSum{
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        String [] str  = sc.next().replace("(","").replace(")","").split(",");
        int [] s = new int [str.length];
        for(int i = 0;i<s.length;i++){
            s[i] = Integer.valueOf(str[i]);
        }
        System.out.println(Maxsum(s));
    }
    public static int Maxsum(int [] s){
        int n = s.length;
        int [] dp = new int[n+1];
        for(int i = n-1;i>=0;i--){
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int j = i;j<n;j++){
                sum+=s[j];
                if(max<sum) max = sum;
            }
            if(max<dp[i+1]) dp[i] = dp[i+1];
            else dp[i] = max;
        }
        return dp[0];
    }
}

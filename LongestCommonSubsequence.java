import java.util.Scanner;


public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.next();
        String Y = sc.next();
        System.out.println(LCS(X,Y));
    }
    public static String LCS(String x,String y){
        int n = x.length();
        int m = y.length();
        String [][] Lcs= new String [n+1][m+1];
        for(int i = 0;i<n+1;i++){
            Lcs[i][m] = "";
        }
        for(int j = 0;j<m+1;j++){
            Lcs[n][j] = "";
        }
        for(int j = m-1;j>=0;j--){
            for(int i = n-1;i>=0;i--){
                if(x.charAt(i) == y.charAt(j)) Lcs[i][j] = x.charAt(i)+Lcs[i+1][j+1] ;
                else {
                    if(Lcs[i][j+1].length()>Lcs[i+1][j].length()) Lcs[i][j] = Lcs[i][j+1];
                    else Lcs[i][j] = Lcs[i+1][j];
                }
            }
        }

        return Lcs[0][0];
    }
}
import java.util.Scanner;

public class MatrixChain {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] str = sc.nextLine().replace("<","").replace(">","").split(",");
        int n = str.length;
        int [][] m = new int [n-1][n-1];
        int [][] s = new int [n-1][n-1];
        int [] p = new int [n];
        for(int i = 0;i<n;i++){
            p[i] = Integer.valueOf(str[i]);
        }
        for(int i = 0;i<n-1;i++){
            for(int j = 0;j<n-1;j++){
                m[i][j] = -1;
            }
        }
        MATRIX_CHAIN_ORDER(p,m,s,0,n-2);
       
        PRINT_OPTIMAL_PARENS(s,0,n-2);
    }
    public static void MATRIX_CHAIN_ORDER(int [] p,int [][]m,int [][] s,int i,int j){
       
        if(i>j) return ;

        if(i==j) {
            m[i][j] = 0;
            return ;
        }
        else {
            int min = Integer.MAX_VALUE;
            int kin = i;
            for(int k = i;k<j;k++){
                if(m[i][k]!=-1&&m[k+1][j]!=-1){
                    int n = m[i][k]+m[k][j]+p[i]*p[k+1]*p[j+1];
                    if(min>n) {
                        min = n;
                        kin = k;
                    }
                }
                else if(m[i][k]!=-1&&m[k+1][j]==-1){
                    MATRIX_CHAIN_ORDER(p,m,s,k+1,j);
                    int n = m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1];
                    if(min>n) {
                        min = n;
                        kin = k;
                    }
                }else if(m[i][k]==-1&&m[k+1][j]!=-1){
                    MATRIX_CHAIN_ORDER(p,m,s,i,k);
                    int n = m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1];
                    if(min>n) {
                        min = n;
                        kin = k;
                    }
                }else if(m[i][k]==-1&&m[k+1][j]==-1){
                    MATRIX_CHAIN_ORDER(p,m,s,i,k);
                    MATRIX_CHAIN_ORDER(p,m,s,k+1,j);
                    int n = m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1];
                    if(min>n) {
                        min = n;
                        kin = k;
                    }
                }
            }
            m[i][j] = min;
            s[i][j] = kin;
        }
    }
    public static void PRINT_OPTIMAL_PARENS(int [][] s,int i,int j){
        if(i==j) System.out.print("A");
        else{
            System.out.print("(");
            PRINT_OPTIMAL_PARENS(s,i,s[i][j]);
            PRINT_OPTIMAL_PARENS(s,s[i][j]+1,j);
            System.out.print(")");
        }
    }
}
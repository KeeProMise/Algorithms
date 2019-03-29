public class QUICKSORT{
    public static void exchange(int [] A,int i,int j){
        int T = A[i];
        A[i] = A[j];
        A[j] = T;
    }
    public static int Partition(int [] A,int p,int r){
        int x = A[r];
        int i = p;
        for(int j = p;j<=r-1;j++){
            if(A[j]<=x){
                exchange(A,i,j);
                i++;
            }
        }
        exchange(A,i,r);
        return i;
    }
    public static void QuickSort(int [] A,int p,int r){
        if(p<r){
            int q = Partition(A,p,r);
            QuickSort(A,p,q-1);
            QuickSort(A,p+1,r);
        }
    }
}
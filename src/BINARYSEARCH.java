public class BINARYSEARCH{
    public static int BinarySearch(int [] A,int v,int p,int r){
        int n = (p+r)/2;
        if(p==n) {
            if(v!=A[p]&&v!=A[r]) return -1;
        }
        if(v==A[n]) return n;
        else if(v>A[n]) return  BinarySearch(A,v,p+1,r);
        else return BinarySearch(A,v,p,r-1);
    }
}
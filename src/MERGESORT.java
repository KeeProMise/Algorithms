public class MERGESORT{
    
   public static void Merge(int [] A,int p,int q,int r){
       int i,j,k;
       int n1 = q-p+1;
       int n2 = r-q;
       int [] L = new int[n1];
       int [] R = new int[n2];
       for(i=0,k=p;i<n1;i++,k++){
           L[i]=A[k];
       }
       for(i=0,k=q+1;i<n2;i++,k++){
           R[i]=A[k];
       }
       for(k=p,i=0,j=0;i<n1&&j<n2;k++){
           if(L[i]<R[j]){
               A[k]=L[i];
               i++;
           }
           else{
                A[k]=R[j];
                j++;
           }
       }
        if(i<n1){
            for(j=i;j<n1;j++,k++){
                A[k]=L[j];
            }
        }
        if(j<n2){
            for(i=j;i<n2;i++,k++){
                A[k]=R[i];
            }
        }
   }
   public static void MergeSort(int []A,int p,int r){
       if(p<r){
           int q = (p+r)/2;
            MergeSort(A,p,q);
            MergeSort(A,q+1,r);
            Merge(A,p,q,r);
       }
   }
   
}

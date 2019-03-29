public class PRIORITYQUEUE{
    public static int heap_size=-1;
    public static int [] A = new int [0];
    public static int PARENT(int i){
        if(i==1) return 0;
        return (int)Math.ceil(i/2-1);
    }
    public static int LEFT(int i){
        return 2*i+1;
    }
    public static int RIGHT(int i){
        return 2*(i+1);
    }
    public static void exchange(int i,int j){
        int T = A[i];
        A[i] = A[j];
        A[j] = T;
    }
    public static void MAX_HEAPIFY(int i){
        int largest;
        int l = LEFT(i);
        int r = RIGHT(i);
        if(l<=heap_size&&A[l]>A[i])  largest = l;
        else largest = i;
        if(r<=heap_size&&A[r]>A[largest]) largest = r;
        if(largest!=i) {
            exchange(i,largest);
            MAX_HEAPIFY(largest);
        }
    }
    public static int MAXIMUM(){
        if(heap_size<0) {
            System.out.println("Null");
            return 0;
        } 
        else return A[0];
    }
    public static int EXTRACT_MAX(){
        if(heap_size<0) {
            System.out.println("heap underflow");
        }
        int max = A[0];
        A[0] = A[heap_size];
        heap_size--;
        MAX_HEAPIFY(0);
        return max;
    }
    public static void INCREASE_KEY(int i,int key){
        if(key<A[i]) System.out.println("new key is smaller than current key");
        A[i] = key;
        while(i>0&&A[PARENT(i)]<A[i]){
            exchange(i,PARENT(i));;
            i = PARENT(i);
        }
    }
    public static void INSERT(int key){
        heap_size++;
        if(heap_size>A.length-1) {
            int [] newA = new int [A.length+1];
            for(int i = 0;i<A.length;i++){
                newA[i] = A[i];
            }
            A = newA;
            newA = null;
        }
        System.gc();
        A[heap_size] = -(int)(Math.pow(2,32)-1);
        INCREASE_KEY(heap_size,key);
    }
    public static void print(){
        for(int i=0;i<=heap_size-1;i++){
            System.out.print(A[i]);
            System.out.print(" ");
        }
        System.out.println(A[heap_size]);
    }
}
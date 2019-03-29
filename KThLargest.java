public class KThLargest{
    public static int Kth(int [] n,int x,int y,int k){
        if(x>y) return -1;
        int t = (y-x)/2;
        if(t+1==k) return n[(y+x)/2];
        else if(t+1<k) return Kth(n,x+t+1,y,k-t-1);
        else return Kth(n,x,x+t-1,k);
    }

    public static int Kth(int [] m,int p,int r,int [] n,int x,int y,int k){
        if(p>r||x>y){
            if(p>r&&x>y) return -1;
            else if(p>r) return  Kth(n,x,y,k);
            else return Kth(m,p,r,k);
        }
        else{
            int mt = (r-p)/2;
            int nt = (y-x)/2;
            int mx = (r+p)/2;
            int nx = (x+y)/2;
            if(mt+nt+2==k){
                if(m[mx]>n[nx]) return Kth(m,p+mt+1,r,n,x,y,k-mt-1);
                else return Kth(m,p,r,n,x+nt+1,y,k-nt-1);
            }
            if(mt+nt+2<k){
                if(m[mx]>n[nx]) return Kth(m,p+mt+1,r,n,x,y,k-mt-1);
                else return Kth(m,p,r,n,x+nt+1,y,k-nt-1);
            }
            else {
                if(m[mx]>n[nx]) return Kth(m,p,r,n,x,x+nt-1,k);
                else return Kth(m,p,p+mt-1,n,x,y,k);
            }
        }
    }
    
    public static int kthLargest(int [] m,int [] n,int k){
        return Kth(m,0,m.length-1,n,0,n.length-1,k);
    }
}
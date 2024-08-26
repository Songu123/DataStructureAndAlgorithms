package ctdl_gt.fibonnaci;

public class Fibonacci {
    public static int TinhSoThuN(int n){
        if (n <= 1){
            return n;
        }else {
            return  TinhSoThuN(n -1 ) + TinhSoThuN(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(TinhSoThuN(6));
    }

}

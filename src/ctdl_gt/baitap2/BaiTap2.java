package ctdl_gt.baitap2;

public class BaiTap2 {
    public static void main(String[] args) {
        System.out.println(luyThua(3,2));
    }

    public static int luyThua(int x, int n) {
        if (n == 0){
            return x = 1;
        }else {
            return x * luyThua(x, n-1);
        }
    }
}

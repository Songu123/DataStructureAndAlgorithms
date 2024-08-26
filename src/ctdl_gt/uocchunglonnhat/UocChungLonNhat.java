package ctdl_gt.uocchunglonnhat;

public class UocChungLonNhat {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;  // Trường hợp suy biến: khi b = 0, trả về a
        }
        return gcd(b, a % b);  // Hạ bậc: Gọi lại hàm gcd với b và phần dư
    }

    public static void main(String[] args) {
        int a = 48;
        int b = 20;
        System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + gcd(a, b));
    }
}

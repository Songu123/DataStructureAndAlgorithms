package ctdl_gt.nhiphan;

public class BinaryConversion {

    public static void printBinary(int n) {
        if (n > 1) {
            printBinary(n / 2);
        }
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        int number = 13;
        System.out.print("Số nhị phân của " + number + " là: ");
        printBinary(number);
        System.out.println();
    }
}

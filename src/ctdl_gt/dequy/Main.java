package ctdl_gt.dequy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập n: ");
            int n = sc.nextInt();
            System.out.println("Giai thừa cuả n = " + giaiThua(n));
        }

    }

    public static int giaiThua(int n){
        if(n == 0){
            return 1;
        }else {
            return n*giaiThua(n-1);
        }
    }
}
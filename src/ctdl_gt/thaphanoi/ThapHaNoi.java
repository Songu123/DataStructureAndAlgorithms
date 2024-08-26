package ctdl_gt.thaphanoi;

public class ThapHaNoi {

    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Di chuyển đĩa 1 từ cột " + source + " sang cột " + destination);
            return;
        }
        solveHanoi(n - 1, source, destination, auxiliary);

        System.out.println("Di chuyển đĩa " + n + " từ cột " + source + " sang cột " + destination);

        solveHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int n = 3;
        solveHanoi(n, 'A', 'B', 'C');
    }
}


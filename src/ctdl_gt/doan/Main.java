package ctdl_gt.doan;

import ctdl_gt.binarytree.BinaryTree;
import ctdl_gt.dothi.BFS;
import ctdl_gt.dothi.DFS;
import ctdl_gt.dothi.Graph;
import ctdl_gt.dslkdoi.DoubleLinkList;
import ctdl_gt.dslkdon.LinkList;
import javafx.scene.transform.Scale;

import java.awt.*;
import java.util.Scanner;

import static ctdl_gt.dequy.Main.giaiThua;
import static ctdl_gt.dslkdoi.Main.printMenu;
import static ctdl_gt.dslkdon.Main.menu;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static LinkList list = new LinkList();
    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        boolean run = true;
        while (run) {
            System.out.println("╔════════════════════════════╗");
            System.out.println("║         MENU CHÍNH         ║");
            System.out.println("╠════════════════════════════╣");
            System.out.println("║ 1. Binary tree             ║");
            System.out.println("║ 2. Đệ Quy                  ║");
            System.out.println("║ 3. Đồ thị                  ║");
            System.out.println("║ 4. Danh sách liên kết đôi  ║");
            System.out.println("║ 5. Danh sách liên kết đơn  ║");
            System.out.println("║ 0. Thoát                   ║");
            System.out.println("╚════════════════════════════╝");
            System.out.print("Lựa chọn: ");

            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Binary tree");
                    binaryTreeFunction();
                    break;
                case 2:
                    System.out.println("Đệ Quy");
                    deQuyFunction();
                    break;
                case 3:
                    System.out.println("Đồ thị");
                    doThiFunction();
                    break;
                case 4:
                    System.out.println("Danh sách liên kết đôi");
                    dslkdoiFunction();
                    break;
                case 5:
                    System.out.println("Danh sách liên kết đơn");
                    dslkdonFunction();
                    break;
                case 0:
                    run = false; // Kết thúc vòng lặp khi chọn 0
                    break;
                default:
                    System.out.println("Nhập sai! Vui lòng nhập lại!");
            }
        }
    }

    public static void binaryTreeFunction() {
        BinaryTree tree = new BinaryTree();
        tree.create();

        // Display all students (inorder traversal)
        System.out.println("\nInorder Traversal of the Tree:");
        tree.duyetIf();
        tree.displayTreeAndInfo();

        System.out.println("Nhập sinh viên cần xoá!");
        String maSV = sc.nextLine();

        tree.deleteStudent(maSV);

        System.out.println("\nInorder Traversal of the Tree:");
        tree.duyetIf();
        tree.displayTreeAndInfo();
    }

    public static void doThiFunction() {
        Graph graph = new Graph(5);

        // Thêm các cạnh vào đồ thị
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        // Tạo đối tượng BFS và DFS để duyệt đồ thị
        BFS bfsTraversal = new BFS();
        DFS dfsTraversal = new DFS();

        System.out.println("Duyệt theo chiều rộng (BFS) từ đỉnh 0:");
        bfsTraversal.bfs(graph, 0); // Kết quả: 0 1 2 3 4

        System.out.println("\nDuyệt theo chiều sâu (DFS) từ đỉnh 0:");
        dfsTraversal.dfs(graph, 0); // Kết quả: 0 1 3 4 2
    }

    public static void deQuyFunction () {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập n: ");
            int n = sc.nextInt();
            System.out.println("Giai thừa cuả n = " + giaiThua(n));
        }
    }

    public static void dslkdonFunction () {
        list.docfile();
        menu();
    }

    public static void dslkdoiFunction () {
        DoubleLinkList doubleLinkList = new DoubleLinkList();
        doubleLinkList.docFile(); // Đọc dữ liệu từ file khi bắt đầu

        boolean ok = true;
        while (ok) {
            printMenu(); // Hiển thị menu
            int choose = sc.nextInt();
            sc.nextLine(); // Đọc dòng mới

            switch (choose) {
                case 1:
                    System.out.println("===============THÊM SINH VIÊN==========");
                    doubleLinkList.createList(); // Thêm sinh viên
                    doubleLinkList.ghiFile(); // Ghi dữ liệu vào file

                    break;
                case 2:
                    System.out.println("===============XOÁ SINH VIÊN==========");
                    System.out.println("Nhập mã sinh viên cần xoá: ");
                    String masv = sc.nextLine();
                    doubleLinkList.deleteWithSearch(masv); // Xóa sinh viên
                    doubleLinkList.resetFile(); // Reset file
                    doubleLinkList.ghiFile(); // Ghi dữ liệu mới vào file
                    break;
                case 3:
                    System.out.println("===============SINH VIÊN CÓ ĐIỂM TB LỚN NHẤT==========");
                    doubleLinkList.findMaxCore();
                    break;
                case 4:
                    System.out.println("===============SẮP XẾP DANH SÁCH SINH VIÊN==========");
                    doubleLinkList.bubbleSortByDiem(); // Sắp xếp danh sách
                    doubleLinkList.ghiFile(); // Ghi dữ liệu đã sắp xếp vào file
                    break;
                case 5:
                    System.out.println("===============HIỂN THỊ DANH SÁCH SINH VIÊN==========");
                    doubleLinkList.printListFull(); // In danh sách sinh viên
                    break;
                case 6:
                    System.out.println("===============THỐNG KÊ==========");
                    doubleLinkList.thongKe(); // In danh sách sinh viên
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    ok = false; // Thoát vòng lặp
                    break;
                default:
                    System.out.println("Nhập sai! Vui lòng nhập lại!");
            }
        }

        sc.close(); // Đóng Scanner khi không sử dụng nữa
    }


}

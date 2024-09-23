package ctdl_gt.dslkdoi;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
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

    public static void printMenu() {
        System.out.println("+-------------------------------------+");
        System.out.println("|           QUẢN LÝ SINH VIÊN         |");
        System.out.println("+-------------------------------------+");
        System.out.printf("| %-35s |\n", "1. Thêm sinh viên");
        System.out.printf("| %-35s |\n", "2. Xóa sinh viên");
        System.out.printf("| %-35s |\n", "3. Tìm sinh viên có điểm lớn nhất");
        System.out.printf("| %-35s |\n", "4. Sắp xếp danh sách");
        System.out.printf("| %-35s |\n", "5. In danh sách sinh viên");
        System.out.printf("| %-35s |\n", "6. Thống kê sinh viên");
        System.out.printf("| %-35s |\n", "0. Thoát");
        System.out.println("+-------------------------------------+");
        System.out.printf("Chọn chức năng (0-5): ");
    }
}

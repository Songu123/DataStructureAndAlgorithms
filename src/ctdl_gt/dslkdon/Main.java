package ctdl_gt.dslkdon;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static LinkList list = new LinkList();
    public static void main(String[] args) {
////        LinkList list = new LinkList();
////        list.createList();
////        System.out.println("Điểm lớn nhat: " + list.printMax());
////
////        System.out.println(list.search("ma123"));
////        list.printKetQua();
////        list.printXepLoai();
////        LinkedList list1 = new LinkedList<>();
////        list1.remove();
//
//        LinkList obj =new LinkList();
//        obj.ghiFile();
//        obj.docfile();
//        obj.insert("003","D", 2);
//        obj.insert("003","D", 3);
//        obj.insert("003","D", 4);
//        obj.printList();
        list.docfile();
        menu();
    }

    public static void menu(){
        boolean run = true;
        while (run){
            System.out.println("================MENU============");
            System.out.println("1. Hiển thị sinh viên có điểm trung bình lớn hơn hoặc bằng 5.");
            System.out.println("2. Hiển thị đầy đủ danh sách Sinh viên bao gồm kết quả và xếp loại.");
            System.out.println("3. Hiển thị những sinh viên có điểm trung bình lớn nhất.");
            System.out.println("4. Xoá sinh viên có mã sinh viên tuỳ ý");
            System.out.println("5. Sắp xếp họ tn theo chiều tăng dần");
            System.out.println("6. Thống kê học sinh kém, trung bình khá và giỏi (lập bảng).");
            System.out.println("Xin mời chọn:  ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 1:
                    System.out.println("DANH SÁCH SINH VIÊN CÓ ĐIỂM TB >= 5");
                    list.printDiem();
                    break;
                case 2:
                    System.out.println("DANH SÁCH SINH VIÊN CÓ ĐẦY ĐỦ KẾT QUẢ VÀ XẾP LOẠI");
                    list.printXepLoai();
                    break;
                case 3:
                    System.out.println("XOÁ SINH VIÊN THEO ID");
                    System.out.println("Nhập mã sinh viên");
                    String Id = sc.nextLine();
                    list.delete(Id);
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("SẮP XẾP SINH VIÊN THEO HỌ TÊN ");
                    list.sortWithNameIncrease();
                    break;
                case 6:
                    System.out.println("THÔNG KÊ SINH VIÊN");
                    list.printXepLoai();
                    break;
                case 0:
                    System.out.println("Bạn đã thoát chương trình!");
                    return;
                default:
                    System.out.println("Nhập sai! Vui lòng nhập lại!");
            }
        }
    }
}

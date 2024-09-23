package ctdl_gt.dslkdoi;

import ctdl_gt.dslkdon.LinkDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoubleLinkList {
    public DoubleLink first, last;
    DoubleLinkDAO object = new DoubleLinkDAO();

    public DoubleLinkList() {
        first = null; // Khởi tạo danh sách rỗng
        last = null;  // Khởi tạo danh sách rỗng
    }

    // Chèn dữ liệu vào danh sách
    public void insert(String maSV, String hoTen, double diem) {
        DoubleLink nut = new DoubleLink(maSV, hoTen, diem);

        // Nếu danh sách rỗng (first và last đều null), thiết lập nút mới là nút đầu và nút cuối
        if (first == null && last == null) {
            first = nut;
            last = nut;
        } else {
            // Nếu danh sách không rỗng, thêm nút mới vào cuối danh sách
            last.next = nut; // Kết nối nút cuối hiện tại với nút mới
            nut.prev = last; // Thiết lập nút trước của nút mới là nút cuối hiện tại
            last = nut;      // Cập nhật nút cuối thành nút mới
        }

        System.out.println("Thêm sinh viên thành công: " + hoTen);
    }

    // Tạo danh sách liên kết
    public void createList() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên: ");
        String maSV = sc.nextLine();
        System.out.print("Nhập họ tên: ");
        String hoTen = sc.nextLine();
        System.out.print("Nhập điểm: ");
        double diem = sc.nextDouble();
        sc.nextLine(); // Đọc dòng mới để tránh lỗi sau khi nhập số

        if (diem < 0) {
            System.out.println("Điểm không hợp lệ!");
            return; // Kết thúc nếu điểm không hợp lệ
        }

        insert(maSV, hoTen, diem); // Gọi hàm insert
    }

    //    In dữ liệu từ first -> last
    public void printListFirst() {
        DoubleLink current = first;
        System.out.println("+----------+----------------------+----------+----------+----------+");
        System.out.printf("| %-8s | %-20s | %-8s | %-8s | %-8s |\n", "MaSV", "Ho Ten", "Diem", "KQ", "XL");
        System.out.println("+----------+----------------------+----------+----------+----------+");
        while (current != null) {
            System.out.printf("| %-8s | %-20s | %-8.2f | %-8s | %-8s |\n",
                    current.getMaSV(), current.getHoTen(), current.getDiem(), current.getKq(), current.getXl());
            System.out.println("+----------+----------------------+----------+----------+----------+");

            current = current.next;
        }
    }

    //    In list từ last -> first
    public void printListLast() {
        DoubleLink current = last;
        System.out.println("+----------+----------------------+----------+----------+----------+");
        System.out.printf("| %-8s | %-20s | %-8s | %-8s | %-8s |\n", "MaSV", "Ho Ten", "Diem", "KQ", "XL");
        System.out.println("+----------+----------------------+----------+----------+----------+");
        while (current != null) {
            System.out.printf("| %-8s | %-20s | %-8.2f | %-8s | %-8s |\n",
                    current.getMaSV(), current.getHoTen(), current.getDiem(), current.getKq(), current.getXl());
            System.out.println("+----------+----------------------+----------+----------+----------+");
            current = current.prev;
        }
    }

    //    In full list từ first -> last
    public void printListFull() {
        DoubleLink current = first;
        System.out.println("+----------+----------------------+----------+----------+----------+");
        System.out.printf("| %-8s | %-20s | %-8s | %-8s | %-8s |\n", "MaSV", "Ho Ten", "Diem", "KQ", "XL");
        System.out.println("+----------+----------------------+----------+----------+----------+");
        while (current != null) {
            current.setKq(current.getDiem() >= 5 ? "Đậu" : "Gớt");
            current.setXl(current.getDiem() < 5 ? "Kém" : current.getDiem() < 7 ? "TB" : current.getDiem() < 8 ? "Khá" : "Giỏi");
            System.out.printf("| %-8s | %-20s | %-8.2f | %-8s | %-8s |\n",
                    current.getMaSV(), current.getHoTen(), current.getDiem(), current.getKq(), current.getXl());
            System.out.println("+----------+----------------------+----------+----------+----------+");
            current = current.next;
        }
    }

    //    Tìm kiếm
    public DoubleLink search(String maSV) {
        DoubleLink current = first;
        while (current != null && current.getMaSV().compareTo(maSV) != 0) {
            current = current.next;
        }
        return current;
    }

    //    Xoá Sinh viên bất kì theo maSV
    public void deleteWithSearch(String maSV) {
        DoubleLink current = search(maSV);  // Tìm node có mã sinh viên tương ứng
        if (current != null) {
            // Trường hợp node cần xóa là node đầu tiên (first)
            if (current == first) {
                first = current.next;  // Cập nhật first thành node kế tiếp
                if (first != null) {
                    first.prev = null;  // Nếu danh sách không rỗng sau khi xóa, cập nhật first.prev
                }
            } else {
                // Cập nhật next của node trước node hiện tại
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
            }

            // Cập nhật prev của node sau node hiện tại
            if (current.next != null) {
                current.next.prev = current.prev;
            }

            System.out.println("Đã xóa phần tử có mã sinh viên " + current.getMaSV());
        } else {
            System.out.println("Không tìm thấy mã SV cần xóa!");
        }
    }


    //    Sắp xếp sinh viên
    public void bubbleSortByDiem() {
        if (first == null) return;

        boolean swapped;
        DoubleLink current;
        do {
            swapped = false;
            current = first;

            while (current.getNext() != null) {
                if (current.getDiem() > current.getNext().getDiem()) {
                    // Hoán đổi thông tin sinh viên
                    swapData(current, current.getNext());
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
        System.out.println("Sắp xêp thành công!");
    }

    // Hàm hoán đổi dữ liệu giữa hai node
    private void swapData(DoubleLink a, DoubleLink b) {
        String currentMaSV = a.getMaSV();
        String currentHoTen = a.getHoTen();
        double currentDiem = a.getDiem();
        String currentKq = a.getKq();
        String currentXl = a.getXl();

        a.setMaSV(b.getMaSV());
        a.setHoTen(b.getHoTen());
        a.setDiem(b.getDiem());
        a.setKq(b.getKq());
        a.setXl(b.getXl());

        b.setMaSV(currentMaSV);
        b.setHoTen(currentHoTen);
        b.setDiem(currentDiem);
        b.setKq(currentKq);
        b.setXl(currentXl);
    }

    // Hàm in danh sách sinh viên
    public void printList() {
        // Kiểm tra danh sách có rỗng không
        if (first == null) {
            System.out.println("Danh sách rỗng.");
            return;
        }

        // In tiêu đề của bảng với khung
        System.out.println("+----------+----------------------+----------+----------+----------+");
        System.out.printf("| %-8s | %-20s | %-8s | %-8s | %-8s |\n", "MaSV", "Ho Ten", "Diem", "KQ", "XL");
        System.out.println("+----------+----------------------+----------+----------+----------+");

        // Duyệt qua danh sách và in từng sinh viên với khung
        DoubleLink current = first;
        while (current != null) {
            System.out.printf("| %-8s | %-20s | %-8.2f | %-8s | %-8s |\n",
                    current.getMaSV(), current.getHoTen(), current.getDiem(), current.getKq(), current.getXl());
            System.out.println("+----------+----------------------+----------+----------+----------+");
            current = current.getNext();
        }
    }
//  Hàm ghi file full DoubleLink
    public void ghiLaiFile() {
        if (first == null) {
            System.out.println("File ghi rỗng! Không có dữ liệu");
            return;
        }
        // Duyệt qua danh sách và in từng sinh viên với khung
        DoubleLink current = first;
        while (current != null) {
            object.writeFile(current);
            current = current.getNext();
        }
    }

    //  Hàm ghi file full DoubleLink
    public void ghiFile() {
        try {
            object.writeFile(first); // Ghi danh sách vào file
            System.out.println("Ghi file thành công.");
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra khi ghi file: " + e.getMessage());
        }
    }

    // Hàm đọc file
    public void docFile() {
        String filePath = "/Users/admin/Documents/JAVA PROJECT/Data Structure and Algorithms/CTDLK21/src/ctdl_gt/dslkdoi/savefiledoubleLink";

        try {
            DoubleLink p = object.readFile(filePath); // Đọc file và lưu vào biến tạm thời
            if (p != null) {
                this.first = p; // Cập nhật nút đầu tiên
                this.last = findLastNode(p); // Cập nhật nút cuối cùng
                System.out.println("Đọc file thành công. Danh sách đã được cập nhật.");
            } else {
                System.out.println("File rỗng hoặc không chứa dữ liệu hợp lệ.");
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
        }
    }

    private DoubleLink findLastNode(DoubleLink first) {
        DoubleLink p = first;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }
    // Hàm reset File
    public void resetFile() {
        try {
            object.clearFile(); // Xóa nội dung file
            System.out.println("Nội dung file đã được xóa thành công.");
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra khi xóa nội dung file: " + e.getMessage());
        }
    }

    // HÀM TÌM NHỮNG SINH VIÊN CÓ ĐIỂM LỚN NHẤT
    public void findMaxCore(){
        if (first == null) {
            System.out.println("Danh sách sinh viên rỗng!");
            return;
        }
        DoubleLink current = first;
        double maxDiem = first.getDiem();
        List<DoubleLink> maxDiemStudentsList = new ArrayList<>();
        while (current != null){
            if (current.getDiem() > maxDiem){
                maxDiem = current.getDiem();
                maxDiemStudentsList.clear();
                maxDiemStudentsList.add(current);
            }else if (current.getDiem() == maxDiem) {
                maxDiemStudentsList.add(current);
            }
            current = current.next;
        }
        System.out.println("+----------+----------------------+----------+----------+----------+");
        System.out.printf("| %-8s | %-20s | %-8s | %-8s | %-8s |\n", "MaSV", "Ho Ten", "Diem", "KQ", "XL");
        System.out.println("+----------+----------------------+----------+----------+----------+");
        for (DoubleLink doubleLink : maxDiemStudentsList){
            System.out.printf("| %-8s | %-20s | %-8.2f | %-8s | %-8s |\n",
                    doubleLink.getMaSV(), doubleLink.getHoTen(), doubleLink.getDiem(), doubleLink.getKq(), doubleLink.getXl());
            System.out.println("+----------+----------------------+----------+----------+----------+");
        }
    }

//    Thống kê
    public void thongKe(){
        DoubleLink current = first;
        int gioi = 0, kha = 0, tb = 0, kem = 0;
        System.out.println("+----------+----------------------+----------+----------+----------+");
        System.out.printf("| %-8s | %-20s | %-8s | %-8s | %-8s |\n", "MaSV", "Ho Ten", "Diem", "KQ", "XL");
        System.out.println("+----------+----------------------+----------+----------+----------+");
        while (current != null) {
            current.setKq(current.getDiem() >= 5 ? "Đậu" : "Gớt");
            current.setXl(current.getDiem() < 5 ? "Kém" : current.getDiem() < 7 ? "TB" : current.getDiem() < 8 ? "Khá" : "Giỏi");
            if (current.getDiem() < 5) {
                kem++;
            } else if (current.getDiem() < 7) {
                tb++;
            } else if (current.getDiem() < 8) {
                kha++;
            } else {
                gioi++;
            }
            System.out.printf("| %-8s | %-20s | %-8.2f | %-8s | %-8s |\n",
                    current.getMaSV(), current.getHoTen(), current.getDiem(), current.getKq(), current.getXl());
            System.out.println("+----------+----------------------+----------+----------+----------+");
            current = current.next;
        }
        System.out.println("Tổng kết:");
        System.out.println("Số sinh viên Giỏi: " + gioi);
        System.out.println("Số sinh viên Khá: " + kha);
        System.out.println("Số sinh viên Trung Bình: " + tb);
        System.out.println("Số sinh viên Kém: " + kem);
    }



}

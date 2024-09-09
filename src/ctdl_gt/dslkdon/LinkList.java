package ctdl_gt.dslkdon;

import java.util.Scanner;

public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public void insert(String maSV, String hoTen, double diem) {
        Link nut = new Link(maSV, hoTen, diem);
        nut.nextLink = first;
        first = nut;
    }

//    Tạo ds
    public void createList() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Nhap ma sinh vien:");
            String maSV = scanner.nextLine();

            if (maSV.isEmpty()) {
                break;
            } else {
                System.out.println("Nhap ho ten:");
                String hoTen = scanner.nextLine();

                System.out.println("Nhap diem:");
                double diem = scanner.nextDouble();
                scanner.nextLine();

                insert(maSV, hoTen, diem);
            }
        }
        scanner.close();
    }

//    Hiển thị
    public void printList() {
        Link p = first;
        while (p != null) {
            System.out.println(p.getMaSV() + " " + p.getHoTen() + " " + p.getDiem() + " " + p.getKq() + " " + p.getXl());
            p = p.nextLink;
        }
    }

//    Hiển thị điểm TB>=5
    public void printDiem() {
        Link p = first;
        while (p != null) {
            if (p.getDiem() >= 5){
                System.out.println(p.getMaSV() + " " + p.getHoTen() + " " + p.getDiem() + " " + p.getKq() + " " + p.getXl());
            }
            p = p.nextLink;
        }
    }

//    Lớn nhất
    public double printMax() {
        Link p = first;
        double max = p.getDiem();
        while (p != null) {
            if (p.getDiem() > max) {
                max = p.getDiem();
            }
            p = p.nextLink;

        }
        return max;
    }

//    Điền dữ liệu đậu rớt vào kết quả
    public void printKetQua(){
        Link p = first;
        while (p != null){
            p.setKq(p.getDiem() >= 5 ? "Đậu" : "Gớt");
            System.out.println(p.getMaSV() + " " + p.getHoTen() + " " + p.getDiem() + " " + p.getKq());
            p = p.nextLink;
        }
    }

//    Diền dữ liệu vào xếp loại
    public void printXepLoai(){
        Link p = first;
        while (p != null){
            p.setXl(p.getDiem() < 5 ? "Kém" : p.getDiem() < 7 ? "TB" : p.getDiem() < 8 ? "Khá" : "Giỏi");
            System.out.println(p.getMaSV() + " " + p.getHoTen() + " " + p.getDiem() + " " + p.getKq() + " " + p.getXl());
            p = p.nextLink;
        }
    }
}

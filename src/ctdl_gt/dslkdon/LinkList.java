package ctdl_gt.dslkdon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinkList {
    public LinkDAO object = new LinkDAO();
    private Link first;
    public List<Link> listMax = new ArrayList<>();

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
            if (p.getDiem() >= 5) {
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
    public void printKetQua() {
        Link p = first;
        while (p != null) {
            p.setKq(p.getDiem() >= 5 ? "Đậu" : "Gớt");
            System.out.println(p.getMaSV() + " " + p.getHoTen() + " " + p.getDiem() + " " + p.getKq());
            p = p.nextLink;
        }
    }


    //    Diền dữ liệu vào xếp loại
    public void printXepLoai() {
        Link p = first;
        while (p != null) {
            p.setXl(p.getDiem() < 5 ? "Kém" : p.getDiem() < 7 ? "TB" : p.getDiem() < 8 ? "Khá" : "Giỏi");
            System.out.println(p.getMaSV() + " " + p.getHoTen() + " " + p.getDiem() + " " + p.getKq() + " " + p.getXl());
            p = p.nextLink;
        }
    }

    public Link search(String maSV) {
        Link p = first;
        while ((p != null) && (p.getMaSV().equals(maSV) != true)) {
            p = p.nextLink;
        }
        return p;
    }

    public void search02(String maSV) {
        Link p = first;
        while ((p != null) && (p.getMaSV().equals(maSV) != true)) {
            p = p.nextLink;
        }
        if (p == null) {
            System.out.println("KHoong co");
        } else {
            System.out.println("co");
        }
    }

    public void delete(String maSV) {
        Link p = search(maSV);
        if (p != null) {
            if (p == first) {
                first = first.nextLink;
            } else {
                Link v, u = first;
                while ((u.nextLink != p) && (u != null)) u = u.nextLink;
                v = p.nextLink;
                u.nextLink = v;
            }
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Xoa khong thanh cong");
        }
    }

    public void sortList() {
        if (first == null || first.nextLink == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Link current = first;
            Link previous = null;

            while (current != null && current.nextLink != null) {
                Link next = current.nextLink;

                if (current.getDiem() > next.getDiem()) {

                    current.nextLink = next.nextLink;
                    next.nextLink = current;

                    if (previous == null) {

                        first = next;
                    } else {
                        previous.nextLink = next;
                    }

                    swapped = true;
                    previous = next;
                } else {
                    previous = current;
                    current = current.nextLink;
                }
            }
        } while (swapped);
    }

    public void sortWithNameIncrease() {
        Link p, q;
        String id, name;
        double score = 0;
        p = first;
        while (p != null) {
            q = p.nextLink;
            while (q != null) {
                if (p.getHoTen().compareTo(q.getHoTen()) > 0) {
                    id = q.getMaSV();
                    name = q.getHoTen();
                    score = q.getDiem();

                    q.setMaSV(p.getMaSV());
                    q.setHoTen(p.getHoTen());
                    q.setDiem(p.getDiem());

                    p.setMaSV(id);
                    p.setHoTen(name);
                    p.setDiem(score);
                }
                q = q.nextLink;
            }
            p = p.nextLink;
        }

    }

    public void ghiFile() {
        insert("ma123", "Nguyen Van Son", 1);
        insert("ma123", "Nguyen Van Son", 1);
        insert("ma123", "Nguyen Van Son", 1);
        object.writeFile(first);
    }

    public void docfile() {
        first = object.readFile("/Users/admin/Documents/JAVA PROJECT/Data Structure and Algorithms/CTDLK21/src/ctdl_gt/dslkdon/savefile");
    }
}

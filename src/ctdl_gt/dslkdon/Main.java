package ctdl_gt.dslkdon;

public class Main {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.createList();
        System.out.println("Điểm lớn nhat: " + list.printMax());
        list.printKetQua();
        list.printXepLoai();
    }
}

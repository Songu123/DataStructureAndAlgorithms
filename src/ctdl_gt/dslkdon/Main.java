package ctdl_gt.dslkdon;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.createList();
        System.out.println("Điểm lớn nhat: " + list.printMax());

        System.out.println(list.search("ma123"));
        list.printKetQua();
        list.printXepLoai();
        LinkedList list1 = new LinkedList<>();
        list1.remove();
    }
}

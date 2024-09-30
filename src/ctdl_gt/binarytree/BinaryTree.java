package ctdl_gt.binarytree;

import java.util.Scanner;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    private Node insert(Node root, String maSV, String hoTen, double diem) {
        if (root == null) {
            root = new Node(maSV, hoTen, diem);
            return root;
        }

        if (maSV.compareTo(root.getMaSV()) < 0) {
            root.setLeft(insert(root.getLeft(), maSV, hoTen, diem));
        } else if (maSV.compareTo(root.getMaSV()) > 0) {
            root.setRight(insert(root.getRight(), maSV, hoTen, diem));
        }

        return root;
    }

    public void create() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập mã sinh viên (hoặc Enter để kết thúc):");
            String maSV = scanner.nextLine();

            if (maSV.isEmpty()) {
                break;
            } else {
                System.out.println("Nhập họ tên:");
                String hoTen = scanner.nextLine();

                System.out.println("Nhập điểm:");
                double diem = scanner.nextDouble();
                scanner.nextLine(); // consume the newline

                root = insert(root, maSV, hoTen, diem);
            }
        }
    }

    public void displayTreeAndInfo() {
        System.out.println("Cây nhị phân:");
        drawTree(root, 0);
        System.out.println("\nThông tin sinh viên:");
        duyetIf();
    }

    // Phương thức để vẽ cây nhị phân
    private void drawTree(Node node, int level) {
        if (node == null) {
            return;
        }

        // In cây con bên phải trước
        drawTree(node.getRight(), level + 1);

        // In khoảng trắng để tạo hình cây
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.print("|-------");
        }

        // In giá trị của nút
        System.out.println(node.getMaSV() + " (" + node.getHoTen() + ", " + node.getDiem() + ")");

        // In cây con bên trái
        drawTree(node.getLeft(), level + 1);
    }

    public void duyetIf() {
        System.out.println("+----------+----------------------+----------+----------+----------+");
        System.out.printf("| %-8s | %-20s | %-8s | %-8s | %-8s |\n", "MaSV", "Ho Ten", "Diem", "KQ", "XL");
        System.out.println("+----------+----------------------+----------+----------+----------+");
        duyetIf(root);

    }

    private void duyetIf(Node root) {
        if (root != null) {
            duyetIf(root.getLeft());
            root.setKq(root.getDiem() >= 5 ? "Đậu" : "Gớt");
            root.setXl(root.getDiem() < 5 ? "Kém" : root.getDiem() < 7 ? "TB" : root.getDiem() < 8 ? "Khá" : "Giỏi");
            System.out.printf("| %-8s | %-20s | %-8.2f | %-8s | %-8s |\n",
                    root.getMaSV(), root.getHoTen(), root.getDiem(), root.getKq(), root.getXl());
            System.out.println("+----------+----------------------+----------+----------+----------+");
            duyetIf(root.getRight());
        }
    }

    public void deleteStudent(String maSV) {
        root = deleteNode(root, maSV);
    }

    // Phương thức hỗ trợ xóa nút trong cây
    private Node deleteNode(Node root, String maSV) {
        if (root == null) {
            return null;
        }

        if (maSV.compareTo(root.getMaSV()) < 0) {
            root.setLeft(deleteNode(root.getLeft(), maSV));
        } else if (maSV.compareTo(root.getMaSV()) > 0) {
            root.setRight(deleteNode(root.getRight(), maSV));
        } else {
            // Nút cần xóa được tìm thấy
            if (root.getLeft() == null) {
                return root.getRight(); // Nút không có con trái
            } else if (root.getRight() == null) {
                return root.getLeft();  // Nút không có con phải
            }

            Node minNode = findMin(root.getRight());
            root.setMaSV(minNode.getMaSV());
            root.setHoTen(minNode.getHoTen());
            root.setDiem(minNode.getDiem());

            root.setRight(deleteNode(root.getRight(), minNode.getMaSV())); // Xóa nút thay thế
        }
        return root;
    }

    // Phương thức tìm nút nhỏ nhất (left-most) trong cây
    private Node findMin(Node root) {
        while (root.getLeft() != null) {
            root = root.getLeft();
        }
        return root;
    }

}

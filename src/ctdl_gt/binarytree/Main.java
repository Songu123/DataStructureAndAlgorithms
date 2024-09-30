package ctdl_gt.binarytree;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static String DB_URL = "jdbc:mysql://localhost:3306/binary_tree";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        // Create the tree by entering nodes
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

        // Display students with 'diem' >= 5
//        try {
//            // Connect to the database
//            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
//            if (conn != null) {
//                // Create statement
//                Statement stmt = conn.createStatement();
//                // Get data from table 'student'
//                ResultSet rs = stmt.executeQuery("SELECT * FROM SinhVien");
//                // Show data
//                while (rs.next()) {
//                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
//                            + "  " + rs.getString(3)  + "  " + rs.getString(4)  + "  " + rs.getString(5) );
//                }
//                // Close the connection
//                conn.close();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }

    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            // Using the updated MySQL driver
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connected successfully!");
        } catch (SQLException ex) {
            System.out.println("Connection failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}

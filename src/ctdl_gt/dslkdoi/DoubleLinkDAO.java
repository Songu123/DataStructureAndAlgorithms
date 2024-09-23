package ctdl_gt.dslkdoi;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DoubleLinkDAO {

    private static final String FILE_PATH = "/Users/admin/Documents/JAVA PROJECT/Data Structure and Algorithms/CTDLK21/src/ctdl_gt/dslkdoi/savefiledoubleLink";

    // Ghi danh sách liên kết vào file
    public void writeFile(DoubleLink first) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(FILE_PATH)))) {
            oos.writeObject(first);
            System.out.println("Ghi DoubleLinkedList vào file thành công.");
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi ghi vào file: " + e.getMessage());
        }
    }

    // Đọc danh sách liên kết từ file
    public DoubleLink readFile(String filename) {
        DoubleLink first = null;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            first = (DoubleLink) ois.readObject();  // Đọc đối tượng đầu tiên
            if (first != null) {
                System.out.println("Đọc LinkedList từ file thành công.");
            } else {
                System.out.println("File rỗng hoặc không có dữ liệu hợp lệ.");
            }
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc từ file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Lớp không được tìm thấy: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Có lỗi khác xảy ra: " + e.getMessage());
        }
        return first;  // Trả về danh sách liên kết bắt đầu từ `first`
    }


    // Xóa nội dung của file
    public void clearFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(""); // Ghi một chuỗi rỗng để xóa nội dung
            System.out.println("Nội dung file đã được xóa.");
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi xóa nội dung file: " + e.getMessage());
        }
    }
}

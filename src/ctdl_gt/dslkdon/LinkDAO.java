package ctdl_gt.dslkdon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LinkDAO {

    public void writeFile(Link first) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("/Users/admin/Documents/JAVA PROJECT/Data Structure and Algorithms/CTDLK21/src/ctdl_gt/dslkdon/savefile")))) {
            oos.writeObject(first);
            System.out.println("Ghi LinkedList vào file thành công.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Link readFile(String filename){
        Link first = new Link();
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))) {
            first = (Link) ois.readObject();
            System.out.println("Đọc LinkedList từ file thành công.");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return first;
    }

}

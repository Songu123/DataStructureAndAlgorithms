package ctdl_gt.dothi;

import java.util.LinkedList;

public class BFS {

    // Duyệt theo chiều rộng (BFS)
    public void bfs(Graph graph, int start) {
        int V = graph.getV(); // Lấy số lượng đỉnh từ đồ thị
        boolean visited[] = new boolean[V]; // Mảng đánh dấu các đỉnh đã thăm
        LinkedList<Integer> queue = new LinkedList<>(); // Hàng đợi cho BFS

        // Đánh dấu đỉnh bắt đầu là đã thăm và thêm vào hàng đợi
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll(); // Lấy đỉnh ra khỏi hàng đợi
            System.out.print(v + " "); // In đỉnh ra

            // Lấy tất cả các đỉnh kề chưa được thăm
            for (int neighbor : graph.getAdj(v)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Đánh dấu là đã thăm
                    queue.add(neighbor); // Thêm vào hàng đợi
                }
            }
        }
    }
}

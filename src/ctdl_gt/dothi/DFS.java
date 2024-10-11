package ctdl_gt.dothi;

public class DFS {

    // Duyệt theo chiều sâu (DFS)
    public void dfs(Graph graph, int start) {
        int V = graph.getV(); // Lấy số lượng đỉnh từ đồ thị
        boolean visited[] = new boolean[V]; // Mảng đánh dấu các đỉnh đã thăm
        dfsUtil(graph, start, visited); // Gọi hàm đệ quy để bắt đầu DFS
    }

    // Hàm đệ quy để thực hiện DFS
    private void dfsUtil(Graph graph, int v, boolean visited[]) {
        // Đánh dấu đỉnh v là đã thăm và in ra
        visited[v] = true;
        System.out.print(v + " ");

        // Lặp qua tất cả các đỉnh kề chưa được thăm
        for (int neighbor : graph.getAdj(v)) {
            if (!visited[neighbor]) {
                dfsUtil(graph, neighbor, visited); // Đệ quy với đỉnh kề
            }
        }
    }
}

package ctdl_gt.dothi;

import java.util.LinkedList;

public class Graph {
    private int V; // Số lượng đỉnh
    private LinkedList<Integer>[] adj; // Mảng các danh sách kề

    // Hàm khởi tạo đồ thị
    public Graph(int V) {
        this.V = V;
        adj = new LinkedList[V]; // Tạo mảng danh sách kề
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList<>(); // Khởi tạo danh sách kề cho mỗi đỉnh
        }
    }

    // Thêm cạnh từ u đến v
    public void addEdge(int u, int v) {
        adj[u].add(v); // Thêm v vào danh sách kề của u
    }

    // Trả về số lượng đỉnh
    public int getV() {
        return V;
    }

    // Trả về danh sách kề của một đỉnh
    public LinkedList<Integer> getAdj(int v) {
        return adj[v];
    }
}

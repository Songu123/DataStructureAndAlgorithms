package ctdl_gt.dothi;

public class Main {
    public static void main(String[] args) {
        // Tạo đồ thị với 5 đỉnh
        Graph graph = new Graph(5);

        // Thêm các cạnh vào đồ thị
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        // Tạo đối tượng BFS và DFS để duyệt đồ thị
        BFS bfsTraversal = new BFS();
        DFS dfsTraversal = new DFS();

        System.out.println("Duyệt theo chiều rộng (BFS) từ đỉnh 0:");
        bfsTraversal.bfs(graph, 0); // Kết quả: 0 1 2 3 4

        System.out.println("\nDuyệt theo chiều sâu (DFS) từ đỉnh 0:");
        dfsTraversal.dfs(graph, 0); // Kết quả: 0 1 3 4 2
    }
}

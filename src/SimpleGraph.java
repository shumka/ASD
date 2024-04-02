import java.util.*;

class Vertex
{
    public int Value;
    public boolean Hit;
    public Vertex(int val)
    {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value) {
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == null) {
                vertex[i] = new Vertex(value);
                break;
            }
        }
    }

    public void RemoveVertex(int v) {
        if (v < 0 || v >= max_vertex || vertex[v] == null) return;
        vertex[v] = null;
        for (int i = 0; i < max_vertex; i++) {
            m_adjacency[v][i] = 0;
            m_adjacency[i][v] = 0;
        }
    }

    public boolean IsEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= max_vertex || v2 < 0 || v2 >= max_vertex) return false;
        return m_adjacency[v1][v2] == 1;
    }

    public void AddEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= max_vertex || v2 < 0 || v2 >= max_vertex) return;
        m_adjacency[v1][v2] = 1;
        m_adjacency[v2][v1] = 1;
    }

    public void RemoveEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= max_vertex || v2 < 0 || v2 >= max_vertex) return;
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo) {
        ArrayList<Vertex> path = new ArrayList<>();
        boolean[] visited = new boolean[max_vertex];
        int[] parent = new int[max_vertex];

        Stack<Integer> stack = new Stack<>();
        stack.push(VFrom);
        visited[VFrom] = true;
        parent[VFrom] = -1;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            if (currentVertex == VTo) {
                // Восстанавливаем путь
                int v = VTo;
                while (v != -1) {
                    path.add(vertex[v]);
                    v = parent[v];
                }
                Collections.reverse(path);
                return path;
            }

            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[currentVertex][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    parent[i] = currentVertex;
                }
            }
        }

        return path; // Путь не найден
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        ArrayList<Vertex> path = new ArrayList<>();
        boolean[] visited = new boolean[max_vertex];
        int[] parent = new int[max_vertex];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(VFrom);
        visited[VFrom] = true;
        parent[VFrom] = -1;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            if (currentVertex == VTo) {
                // Восстанавливаем путь
                int v = VTo;
                while (v != -1) {
                    path.add(vertex[v]);
                    v = parent[v];
                }
                Collections.reverse(path);
                return path;
            }

            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[currentVertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    parent[i] = currentVertex;
                }
            }
        }

        return path; // Путь не найден
    }

}
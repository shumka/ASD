import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGraphTest {

    @Test
    public void testGraphOperations() {
        SimpleGraph graph = new SimpleGraph(5);

        // Test AddVertex
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        assertEquals(1, graph.vertex[0].Value);
        assertEquals(2, graph.vertex[1].Value);
        assertEquals(3, graph.vertex[2].Value);

        // Test RemoveVertex
        graph.RemoveVertex(1);
        assertNull(graph.vertex[1]);

        // Test IsEdge
        graph.AddEdge(0, 2);
        assertTrue(graph.IsEdge(0, 2));
        assertFalse(graph.IsEdge(0, 1));

        // Test AddEdge
        graph.AddEdge(0, 1);
        assertTrue(graph.IsEdge(0, 1));

        // Test RemoveEdge
        graph.RemoveEdge(0, 2);
        assertFalse(graph.IsEdge(0, 2));
    }


    @Test
    void testFindNodesNotInTriangle() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);

        // Создаем треугольник 0-1-2
        graph.AddEdge(0, 1);
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 0);

        // Добавляем дополнительные ребра
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 4);

        // Проверяем, что узлы 3 и 4 не входят ни в один треугольник
        ArrayList<Vertex> nodesNotInTriangle = graph.WeakVertices();
        assertTrue(containsVertexWithValue(nodesNotInTriangle, 3));
        assertTrue(containsVertexWithValue(nodesNotInTriangle, 4));

        // Проверяем, что узел 1 входит в треугольник
        assertFalse(containsVertexWithValue(nodesNotInTriangle, 1));
    }

    private boolean containsVertexWithValue(ArrayList<Vertex> vertices, int value) {
        for (Vertex vertex : vertices) {
            if (vertex.Value == value) {
                return true;
            }
        }
        return false;
    }
}
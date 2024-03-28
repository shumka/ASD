import org.junit.jupiter.api.Test;

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
}
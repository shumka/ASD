import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleTreeTest {

    @Test
    void testAddChild() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(1, null));
        SimpleTreeNode<Integer> childNode = new SimpleTreeNode<>(2, null);
        tree.AddChild(tree.Root, childNode);
        assertTrue(tree.Root.Children.contains(childNode));
        assertEquals(childNode.Parent, tree.Root);
    }

    @Test
    void testDeleteNode() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(1, null));
        SimpleTreeNode<Integer> childNode = new SimpleTreeNode<>(2, null);
        tree.AddChild(tree.Root, childNode);
        tree.DeleteNode(childNode);
        assertFalse(tree.Root.Children.contains(childNode));
        assertNull(childNode.Parent);
    }

    @Test
    void testGetAllNodes() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(1, null));
        SimpleTreeNode<Integer> childNode = new SimpleTreeNode<>(2, null);
        tree.AddChild(tree.Root, childNode);
        assertEquals(2, tree.GetAllNodes().size());
    }

    @Test
    void testFindNodesByValue() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(1, null));
        SimpleTreeNode<Integer> childNode = new SimpleTreeNode<>(2, null);
        tree.AddChild(tree.Root, childNode);
        assertEquals(1, tree.FindNodesByValue(2).size());
    }

    @Test
    void testMoveNode() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(1, null));
        SimpleTreeNode<Integer> childNode = new SimpleTreeNode<>(2, null);
        tree.AddChild(tree.Root, childNode);
        SimpleTreeNode<Integer> newParentNode = new SimpleTreeNode<>(3, null);
        tree.AddChild(tree.Root, newParentNode);
        tree.MoveNode(childNode, newParentNode);
        assertFalse(tree.Root.Children.contains(childNode));
        assertTrue(newParentNode.Children.contains(childNode));
        assertEquals(childNode.Parent, newParentNode);
    }

    @Test
    void testCount() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(1, null));
        SimpleTreeNode<Integer> childNode = new SimpleTreeNode<>(2, null);
        tree.AddChild(tree.Root, childNode);
        assertEquals(2, tree.Count());
    }

    @Test
    void testLeafCount() {
        SimpleTree<Integer> tree = new SimpleTree<>(new SimpleTreeNode<>(1, null));
        SimpleTreeNode<Integer> childNode = new SimpleTreeNode<>(2, null);
        tree.AddChild(tree.Root, childNode);
        assertEquals(1, tree.LeafCount());
    }
}
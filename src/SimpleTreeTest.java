import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

    @Test
    public void testEvenTrees() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(1, null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<>(2, root);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<>(3, root);
        SimpleTreeNode<Integer> node6 = new SimpleTreeNode<>(6, root);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<>(5, node2);
        SimpleTreeNode<Integer> node7 = new SimpleTreeNode<>(7, node2);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<>(4, node3);
        SimpleTreeNode<Integer> node8 = new SimpleTreeNode<>(8, node6);
        SimpleTreeNode<Integer> node9 = new SimpleTreeNode<>(9, node8);
        SimpleTreeNode<Integer> node10 = new SimpleTreeNode<>(10, node8);

        SimpleTree<Integer> tree = new SimpleTree<>(root);
        tree.AddChild(root, node2);
        tree.AddChild(root, node3);
        tree.AddChild(root, node6);
        tree.AddChild(node2, node5);
        tree.AddChild(node2, node7);
        tree.AddChild(node3, node4);
        tree.AddChild(node6, node8);
        tree.AddChild(node8, node9);
        tree.AddChild(node8, node10);

        ArrayList<Integer> result = tree.EvenTrees();
        assertNotNull(result);

        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(1, 3, 1, 6));
        ArrayList<Integer> actualResult = tree.EvenTrees();

        assertArrayEquals(expectedResult.toArray(), actualResult.toArray());
    }

}
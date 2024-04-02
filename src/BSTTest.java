//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import java.util.ArrayList;
//
//
//class BSTTest {
//
//    @Test
//    void findNodeByKey() {
//        BST<Integer> bst = new BST<>(null);
//        assertFalse(bst.FindNodeByKey(5).NodeHasKey); // Ожидаем false, дерево пустое
//        bst.AddKeyValue(5, 50);
//        assertTrue(bst.FindNodeByKey(5).NodeHasKey); // Ожидаем true, узел с ключом 5 добавлен
//        assertFalse(bst.FindNodeByKey(6).NodeHasKey); // Ожидаем false, узел с ключом 6 отсутствует
//        bst.AddKeyValue(6, 60);
//        assertTrue(bst.FindNodeByKey(6).NodeHasKey); // Ожидаем true, узел с ключом 6 добавлен
//        bst.AddKeyValue(4, 40);
//        assertTrue(bst.FindNodeByKey(4).NodeHasKey); // Ожидаем true, узел с ключом 4 добавлен
//    }
//    @Test
//    void addKeyValue() {
//        BST<Integer> bst = new BST<>(null);
//        assertFalse(bst.FindNodeByKey(3).NodeHasKey); // Ожидаем false, узел с ключом 3 отсутствует
//        assertTrue(bst.AddKeyValue(3, 30)); // Ожидаем true, узел с ключом 3 добавлен
//        assertFalse(bst.AddKeyValue(3, 40)); // Ожидаем true, узел с ключом 3 добавлен
//        assertTrue(bst.AddKeyValue(4, 40)); // Ожидаем false, узел с ключом 4 уже существует
//        assertFalse(bst.AddKeyValue(4, 50)); // Ожидаем false, узел с ключом 4 уже существует
//    }
//
//    @Test
//    void findMinMax() {
//        BST<String> bst = new BST<>(null);
//        bst.AddKeyValue(10, "Value for 10");
//        bst.AddKeyValue(5, "Value for 5");
//        bst.AddKeyValue(15, "Value for 15");
//
//        BSTNode<String> minNode = bst.FinMinMax(bst.Root, false);
//        assertEquals(5, minNode.NodeKey);
//
//        BSTNode<String> maxNode = bst.FinMinMax(bst.Root, true);
//        assertEquals(15, maxNode.NodeKey);
//    }
//
//    @Test
//    void deleteNodeByKey() {
//        BST<Integer> bst = new BST<>(null);
//        bst.AddKeyValue(5, 50);
//        bst.AddKeyValue(6, 60);
//        bst.AddKeyValue(4, 40);
//
//        assertTrue(bst.FindNodeByKey(6).NodeHasKey); // Ожидаем true, узел с ключом 6 существует
//        assertTrue(bst.DeleteNodeByKey(6)); // Ожидаем true, узел с ключом 6 удален
//        assertFalse(bst.FindNodeByKey(6).NodeHasKey); // Ожидаем false, узел с ключом 6 отсутствует
//    }
//
//    @Test
//    void count() {
//        BST<Integer> bst = new BST<>(null);
//        assertEquals(0, bst.Count()); // Ожидаем 0, дерево пустое
//
//        bst.AddKeyValue(10, 10);
//        bst.AddKeyValue(5, 5);
//        bst.AddKeyValue(15, 15);
//
//        assertEquals(3, bst.Count());
//    }
//
//
//    @Test
//    public void testWideAllNodes() {
//        BST<Integer> bst = new BST<>(new BSTNode<>(5, 50, null));
//        bst.AddKeyValue(3, 30);
//        bst.AddKeyValue(8, 80);
//        ArrayList<BSTNode> wideNodes = bst.WideAllNodes();
//        assertEquals(3, wideNodes.size());
//        assertEquals(5, wideNodes.get(0).NodeKey);
//        assertEquals(3, wideNodes.get(1).NodeKey);
//        assertEquals(8, wideNodes.get(2).NodeKey);
//    }
//
//
//    @Test
//    public void testDeepAllNodes() {
//        BST<Integer> bst = new BST<>(new BSTNode<>(5, 50, null));
//        bst.AddKeyValue(3, 30);
//        bst.AddKeyValue(8, 80);
//
//        ArrayList<BSTNode> inOrderNodes = bst.DeepAllNodes(0);
//        assertEquals(3, inOrderNodes.size());
//        assertEquals(3, inOrderNodes.get(0).NodeKey);
//        assertEquals(5, inOrderNodes.get(1).NodeKey);
//        assertEquals(8, inOrderNodes.get(2).NodeKey);
//
//        ArrayList<BSTNode> postOrderNodes = bst.DeepAllNodes(1);
//        assertEquals(3, postOrderNodes.size());
//        assertEquals(3, postOrderNodes.get(0).NodeKey);
//        assertEquals(8, postOrderNodes.get(1).NodeKey);
//        assertEquals(5, postOrderNodes.get(2).NodeKey);
//
//        ArrayList<BSTNode> preOrderNodes = bst.DeepAllNodes(2);
//        assertEquals(3, preOrderNodes.size());
//        assertEquals(5, preOrderNodes.get(0).NodeKey);
//        assertEquals(3, preOrderNodes.get(1).NodeKey);
//        assertEquals(8, preOrderNodes.get(2).NodeKey);
//    }
//
//}
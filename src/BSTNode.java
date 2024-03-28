import java.util.*;

class BSTNode {
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int Level; // глубина узла

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST {
    public BSTNode Root; // корень дерева

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {
        Arrays.sort(a);
        Root = generateTreeRecursive(a, 0, a.length - 1, null);
    }

    private BSTNode generateTreeRecursive(int[] a, int start, int end, BSTNode parent) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        BSTNode node = new BSTNode(a[mid], parent);
        node.Level = (parent != null) ? parent.Level + 1 : 0;
        node.LeftChild = generateTreeRecursive(a, start, mid - 1, node);
        node.RightChild = generateTreeRecursive(a, mid + 1, end, node);
        return node;
    }

    public boolean IsBalanced(BSTNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.LeftChild);
        int rightHeight = getHeight(root.RightChild);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return IsBalanced(root.LeftChild) && IsBalanced(root.RightChild);
    }

    private int getHeight(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.LeftChild), getHeight(node.RightChild));
    }
}
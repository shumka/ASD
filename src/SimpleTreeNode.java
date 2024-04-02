import java.util.*;

public class SimpleTreeNode<T>
{
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

class SimpleTree<T>
{
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        if (ParentNode.Children == null)
            ParentNode.Children = new ArrayList<>();

        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
        if (NodeToDelete.Parent != null)
            NodeToDelete.Parent.Children.remove(NodeToDelete);

        // Удаление ссылок на родителя и детей, поможет сборщику мусора освободить память
        NodeToDelete.Parent = null;
        NodeToDelete.Children = null;
    }

    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        List<SimpleTreeNode<T>> allNodes = new ArrayList<>();
        Queue<SimpleTreeNode<T>> queue = new LinkedList<>();

        if (Root != null)
            queue.add(Root);

        while (!queue.isEmpty()) {
            SimpleTreeNode<T> current = queue.poll();
            allNodes.add(current);

            if (current.Children != null)
                queue.addAll(current.Children);
        }

        return allNodes;
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        List<SimpleTreeNode<T>> foundNodes = new ArrayList<>();
        Queue<SimpleTreeNode<T>> queue = new LinkedList<>();

        if (Root != null)
            queue.add(Root);

        while (!queue.isEmpty()) {
            SimpleTreeNode<T> current = queue.poll();
            if (current.NodeValue.equals(val))
                foundNodes.add(current);

            if (current.Children != null)
                queue.addAll(current.Children);
        }

        return foundNodes;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        if (OriginalNode.Parent != null) {
            OriginalNode.Parent.Children.remove(OriginalNode);
            OriginalNode.Parent = null; // Удаление ссылки на старого родителя
        }

        AddChild(NewParent, OriginalNode);
    }

    public int Count()
    {
        return GetAllNodes().size();
    }

    public int LeafCount()
    {
        int count = 0;
        Queue<SimpleTreeNode<T>> queue = new LinkedList<>();

        if (Root != null)
            queue.add(Root);

        while (!queue.isEmpty()) {
            SimpleTreeNode<T> current = queue.poll();
            if (current.Children == null || current.Children.isEmpty())
                count++;
            else
                queue.addAll(current.Children);
        }

        return count;
    }

    public ArrayList<T> EvenTrees() {
        ArrayList<T> result = new ArrayList<>();
        HashMap<T, Integer> subTreeSizes = new HashMap<>();
        countSubTreeSizes(Root, subTreeSizes);
        int totalSize = Count();
        if (totalSize % 2 == 1) {
            return result; // Невозможно получить лес из чётных деревьев
        }
        HashSet<SimpleTreeNode<T>> removedNodes = new HashSet<>();
        dfsEvenTrees(Root, null, subTreeSizes, totalSize, removedNodes, result);
        return result;
    }

    private void countSubTreeSizes(SimpleTreeNode<T> node, HashMap<T, Integer> subTreeSizes) {
        if (node == null) {
            return;
        }
        int size = 1;
        for (SimpleTreeNode<T> child : node.Children) {
            countSubTreeSizes(child, subTreeSizes);
            size += subTreeSizes.get(child.NodeValue);
        }
        subTreeSizes.put(node.NodeValue, size);
    }

    private void dfsEvenTrees(SimpleTreeNode<T> node, SimpleTreeNode<T> parent, HashMap<T, Integer> subTreeSizes, int totalSize, HashSet<SimpleTreeNode<T>> removedNodes, ArrayList<T> result) {
        if (node == null) {
            return;
        }
        int sizeWithoutNode = totalSize - subTreeSizes.get(node.NodeValue) * 2;
        if (sizeWithoutNode % 2 == 0 && !removedNodes.contains(node)) {
            result.add(parent.NodeValue);
            result.add(node.NodeValue);
            removedNodes.add(node);
        }
        for (SimpleTreeNode<T> child : node.Children) {
            dfsEvenTrees(child, node, subTreeSizes, totalSize, removedNodes, result);
        }
    }


}
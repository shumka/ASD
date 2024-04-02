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

    public ArrayList<T> EvenTrees()
    {
        ArrayList<T> result = new ArrayList<>();
        if (Root == null)
            return result;

        // Шаг 1. Подсчитаем количество вершин в каждом поддереве
        Map<SimpleTreeNode<T>, Integer> subtreeSizes = new HashMap<>();
        countSubtreeSizes(Root, subtreeSizes);

        // Шаг 2. Найдем ребро для удаления в каждом нечетном поддереве
        findOddSubtrees(Root, subtreeSizes, result);

        return result;
    }

    private void countSubtreeSizes(SimpleTreeNode<T> node, Map<SimpleTreeNode<T>, Integer> subtreeSizes)
    {
        if (node == null)
            return;

        int size = 1;
        for (SimpleTreeNode<T> child : node.Children) {
            countSubtreeSizes(child, subtreeSizes);
            size += subtreeSizes.get(child);
        }
        subtreeSizes.put(node, size);
    }

    private void findOddSubtrees(SimpleTreeNode<T> node, Map<SimpleTreeNode<T>, Integer> subtreeSizes, ArrayList<T> result)
    {
        if (node == null)
            return;

        int parentSize = node.Parent == null ? 0 : subtreeSizes.get(node.Parent) - subtreeSizes.get(node);
        if ((parentSize + subtreeSizes.get(node)) % 2 == 1) {
            // Найдено нечетное поддерево, ищем ребро для удаления
            for (SimpleTreeNode<T> child : node.Children) {
                if (subtreeSizes.get(child) % 2 == 1) {
                    // Найдено ребро для удаления
                    result.add(node.NodeValue);
                    result.add(child.NodeValue);

                    // Удаляем ребро и обновляем размеры поддеревьев
                    DeleteNode(child);
                    subtreeSizes.put(node, subtreeSizes.get(node) - subtreeSizes.get(child) - 1);
                    subtreeSizes.put(child, 1);

                    break;
                }
            }
        }

        for (SimpleTreeNode<T> child : node.Children)
            findOddSubtrees(child, subtreeSizes, result);
    }





}
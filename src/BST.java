class BSTNode<T>
{
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок 

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если в дереве вообще нету узлов
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() { Node = null; }
}

class BST<T>
{
    BSTNode<T> Root; // корень дерева, или null

    public BST(BSTNode<T> node)
    {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        BSTFind<T> findResult = new BSTFind<>();
        BSTNode<T> currentNode = Root;

        while (currentNode != null) {
            if (key == currentNode.NodeKey) {
                findResult.Node = currentNode;
                findResult.NodeHasKey = true;
                break;
            } else if (key < currentNode.NodeKey) {
                if (currentNode.LeftChild != null)
                    currentNode = currentNode.LeftChild;
                else {
                    findResult.Node = currentNode;
                    findResult.NodeHasKey = false;
                    findResult.ToLeft = true;
                    break;
                }
            } else {
                if (currentNode.RightChild != null)
                    currentNode = currentNode.RightChild;
                else {
                    findResult.Node = currentNode;
                    findResult.NodeHasKey = false;
                    findResult.ToLeft = false;
                    break;
                }
            }
        }

        return findResult;
    }

    public boolean AddKeyValue(int key, T val) {
        BSTFind<T> findResult = FindNodeByKey(key);

        if (findResult.NodeHasKey)
            return false; // Узел с таким ключом уже существует

        BSTNode<T> newNode = new BSTNode<>(key, val, findResult.Node);
        if (findResult.Node == null) // Дерево было пустым
            Root = newNode;
        else if (findResult.ToLeft)
            findResult.Node.LeftChild = newNode; // Добавляем новый узел слева
        else
            findResult.Node.RightChild = newNode; // Добавляем новый узел справа

        return true;
    }

    public BSTNode<T> FindMinMax(BSTNode<T> FromNode, boolean FindMax) {
        if (FromNode == null)
            return null; // Если поддерево пустое

        BSTNode<T> currentNode = FromNode;
        while ((FindMax && currentNode.RightChild != null) || (!FindMax && currentNode.LeftChild != null))
            currentNode = FindMax ? currentNode.RightChild : currentNode.LeftChild;

        return currentNode;
    }

    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> findResult = FindNodeByKey(key);
        if (!findResult.NodeHasKey)
            return false; // Узел с таким ключом не найден

        BSTNode<T> nodeToDelete = findResult.Node;
        if (nodeToDelete.LeftChild == null && nodeToDelete.RightChild == null) {
            // У узла нет потомков
            if (nodeToDelete.Parent == null)
                Root = null; // Удаляемый узел - корень дерева
            else if (nodeToDelete.Parent.LeftChild == nodeToDelete)
                nodeToDelete.Parent.LeftChild = null; // Узел - левый потомок
            else
                nodeToDelete.Parent.RightChild = null; // Узел - правый потомок
        } else if (nodeToDelete.LeftChild != null && nodeToDelete.RightChild != null) {
            // У узла есть оба потомка
            BSTNode<T> successor = FindMinMax(nodeToDelete.RightChild, false);
            nodeToDelete.NodeKey = successor.NodeKey;
            nodeToDelete.NodeValue = successor.NodeValue;
            if (successor.Parent.LeftChild == successor)
                successor.Parent.LeftChild = null;
            else
                successor.Parent.RightChild = null;
        } else {
            // У узла есть один потомок
            BSTNode<T> child = nodeToDelete.LeftChild != null ? nodeToDelete.LeftChild : nodeToDelete.RightChild;
            if (nodeToDelete.Parent == null)
                Root = child; // Удаляемый узел - корень дерева
            else if (nodeToDelete.Parent.LeftChild == nodeToDelete)
                nodeToDelete.Parent.LeftChild = child;
            else
                nodeToDelete.Parent.RightChild = child;
        }

        return true;
    }

    public int Count()
    {
        return CountNodes(Root);
    }

    private int CountNodes(BSTNode<T> node) {
        if (node == null)
            return 0;
        return 1 + CountNodes(node.LeftChild) + CountNodes(node.RightChild);
    }

}

import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        if (this.head == null)
            return null;

        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {

        if (this.head == null)
            return null;

        ArrayList<Node> nodes = new ArrayList<Node>();

        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int _value)
    {
        if(this.head == null)
            return false;

        Node currNode = this.head;
        Node prevNode = null;

        if(currNode != null && currNode.value == _value){
            head = currNode.next;
            return true;
        }

        while (currNode != null && currNode.value != _value) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (currNode == null)
            return false;

        prevNode.next = currNode.next;

        return true;

    }

    public void removeAll(int _value) {

        if (this.head == null)
            return;

        while (head != null && head.value == _value) {
            head = head.next;
        }

        Node node = head;
        while (node != null && node.next != null) {
            if (node.next.value == _value) {
                node.next = node.next.next;
                if(node.next == null)
                    this.tail = node;
            } else {
                node = node.next;
            }
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {

        if(_nodeAfter == null){
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            return;
        }

        if (_nodeAfter.next == null) {
            _nodeAfter.next = _nodeToInsert;
            this.tail = _nodeToInsert;
        } else {
            Node oldNext = _nodeAfter.next;
            _nodeToInsert.next = oldNext;
            _nodeAfter.next = _nodeToInsert;
        }

    }
}
class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
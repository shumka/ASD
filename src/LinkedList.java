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

        Node node = this.head;
        Node prev = null;

        //If HEAD
        if(node.value == _value) {
            if (node.next == null) {
                this.head = node.next;
                this.tail = node.next;
            } else {
                this.head = node.next;
            }
            return true;
        }
            while (node != null) {
                if(node.value == _value){
                    if(node.next == null){
                        this.tail = prev;
                        prev.next = node.next;
                        return true;
                    }else{
                        prev.next = node.next;
                        return true;
                    }
                }
                prev = node;
                node = node.next;
            }

            return false;
    }

    public void removeAll(int _value) {

        if (this.head == null)
            return;

        while (head != null && head.value == _value) {
            if(head.next == null){
                this.head = head.next;
                this.tail = head.next;
            } else {
                head = head.next;
            }
        }

        Node node = head;
        Node prev = null;

        while (node != null) {
            if(node.value == _value){
                if(node.next == null){
                    this.tail = prev;
                    prev.next = node.next;
                }else{
                    prev.next = node.next;
                }
            }
            prev = node;
            node = node.next;
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
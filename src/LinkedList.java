//import java.util.*;
//
//public class LinkedList
//{
//    public Node head;
//    public Node tail;
//
//    public LinkedList()
//    {
//        head = null;
//        tail = null;
//    }
//
//    public void addInTail(Node item) {
//        if (this.head == null)
//            this.head = item;
//        else
//            this.tail.next = item;
//        this.tail = item;
//    }
//
//    public Node find(int value) {
//        Node node = this.head;
//        while (node != null) {
//            if (node.value == value)
//                return node;
//            node = node.next;
//        }
//        return null;
//    }
//
//    public ArrayList<Node> findAll(int _value) {
//        ArrayList<Node> nodes = new ArrayList<Node>();
//
//        Node node = this.head;
//        while (node != null) {
//            if (node.value == _value){
//                nodes.add(node);
//            }
//            node = node.next;
//        }
//
//        return nodes;
//    }
//
//    public boolean remove(int _value)
//    {
//        if(this.head == null)
//            return false;
//
//        Node node = this.head;
//        Node prev = null;
//
//        if (node != null && node.value == _value) {
//            this.head = node.next;
//            if (this.head == null) this.tail = null;
//            return true;
//        }
//
//        while (node != null && node.value != _value) {
//            prev = node;
//            node = node.next;
//        }
//
//        if (node == null) return false;
//
//        prev.next = node.next;
//
//        if (prev.next == null) tail = prev;
//
//        return true;
//    }
//
//    public void removeAll(int _value) {
//
//        if (this.head == null)
//            return;
//
//        Node node = head;
//        Node prev = null;
//
//        while (node != null && node.value == _value) {
//            this.head = node.next;
//            if (this.head == null) this.tail = null;
//            node = this.head;
//        }
//
//        while (node != null) {
//            while (node != null && node.value != _value) {
//                prev = node;
//                node = node.next;
//            }
//            if (node == null) return;
//            prev.next = node.next;
//            if (prev.next == null) tail = prev;
//            node = prev.next;
//        }
//
//    }
//
//    public void clear()
//    {
//        this.head = null;
//        this.tail = null;
//    }
//
//    public int count()
//    {
//        int count = 0;
//        Node node = this.head;
//        while (node != null) {
//            count++;
//            node = node.next;
//        }
//        return count;
//    }
//
//    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
//    {
//        if (_nodeAfter == null) {
//            _nodeToInsert.next = head;
//            head = _nodeToInsert;
//            if (head.next == null) tail = head;
//        } else {
//            _nodeToInsert.next = _nodeAfter.next;
//            _nodeAfter.next = _nodeToInsert;
//            if (_nodeToInsert.next == null) tail = _nodeToInsert;
//        }
//    }
//}
//class Node
//{
//    public int value;
//    public Node next;
//    public Node(int _value)
//    {
//        value = _value;
//        next = null;
//    }
//}
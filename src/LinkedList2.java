//import java.util.*;
//
//public class LinkedList2
//{
//    public Node head;
//    public Node tail;
//
//    public LinkedList2()
//    {
//        head = null;
//        tail = null;
//    }
//
//    public void addInTail(Node _item)
//    {
//        if (head == null) {
//            this.head = _item;
//            this.head.next = null;
//            this.head.prev = null;
//        } else {
//            this.tail.next = _item;
//            _item.prev = tail;
//        }
//        this.tail = _item;
//    }
//
//    public Node find(int _value)
//    {
//        Node current = head;
//        while (current != null) {
//            if (current.value == _value) {
//                return current;
//            }
//            current = current.next;
//        }
//        return null;
//    }
//
//    public ArrayList<Node> findAll(int _value)
//    {
//        ArrayList<Node> nodes = new ArrayList<Node>();
//        Node current = head;
//
//        while (current != null) {
//            if (current.value == _value) {
//                nodes.add(current);
//            }
//            current = current.next;
//        }
//        return nodes;
//    }
//
//    public boolean remove(int _value)
//    {
//
//        Node node = head;
//        if (node != null && node.value == _value) {
//            head = node.next;
//            if (head != null) {
//                head.prev = null;
//            } else {
//                tail = null;
//            }
//            return true;
//        } else {
//            while (node != null) {
//                if (node.value == _value) {
//                    if (node.next != null) {
//                        node.next.prev = node.prev;
//                    } else {
//                        tail = node.prev;
//                    }
//                    if (node.prev != null) {
//                        node.prev.next = node.next;
//                    } else {
//                        head = node.next;
//                    }
//                    return true;
//                }
//                node = node.next;
//            }
//
//        }
//
//        return false;
//    }
//
//    public void removeAll(int _value)
//    {
//        Node node = head;
//        while (node != null) {
//            if (node.value == _value) {
//                if (node.next != null) {
//                    node.next.prev = node.prev;
//                } else {
//                    tail = node.prev;
//                }
//                if (node.prev != null) {
//                    node.prev.next = node.next;
//                } else {
//                    head = node.next;
//                }
//            }
//            node = node.next;
//        }
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
//        if(this.head != null){
//            int count = 0;
//            Node node = this.head;
//            while (node != null) {
//                count++;
//                node = node.next;
//            }
//            return count;
//        }
//
//        return 0;
//    }
//
//    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
//    {
//        if (_nodeAfter == null) {
//            _nodeToInsert.next = head;
//            if (head != null) {
//                head.prev = _nodeToInsert;
//            }
//            head = _nodeToInsert;
//            if (tail == null) {
//                tail = _nodeToInsert;
//            }
//        } else {
//            _nodeToInsert.next = _nodeAfter.next;
//            _nodeToInsert.prev = _nodeAfter;
//            if (_nodeAfter.next != null) {
//                _nodeAfter.next.prev = _nodeToInsert;
//            } else {
//                tail = _nodeToInsert;
//            }
//            _nodeAfter.next = _nodeToInsert;
//        }
//    }
//}
//
//class Node
//{
//    public int value;
//    public Node next;
//    public Node prev;
//
//    public Node(int _value)
//    {
//        value = _value;
//        next = null;
//        prev = null;
//    }
//}
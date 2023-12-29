import java.util.*;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T extends Comparable<T>> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        return v1.compareTo(v2);
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = tail = node;
        } else if ((_ascending && compare(value, head.value) < 0) || (!_ascending && compare(value, head.value) > 0)) {
            node.next = head;
            head.prev = node;
            head = node;
        } else if ((_ascending && compare(value, tail.value) > 0) || (!_ascending && compare(value, tail.value) < 0)) {
            node.prev = tail;
            tail.next = node;
            tail = node;
        } else {
            Node<T> current = head;
            while (current != null) {
                if ((_ascending && compare(value, current.value) < 0) || (!_ascending && compare(value, current.value) > 0)) {
                    node.next = current;
                    node.prev = current.prev;
                    current.prev.next = node;
                    current.prev = node;
                    break;
                }
                current = current.next;
            }
        }
    }

    public Node<T> find(T val) {
        Node<T> current = head;
        while (current != null) {
            if (compare(val, current.value) == 0) {
                return current;
            } else if ((_ascending && compare(val, current.value) < 0) || (!_ascending && compare(val, current.value) > 0)) {
                return null;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(T val) {
        Node<T> node = find(val);
        if (node != null) {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            if (node == head) {
                head = node.next;
            }
            if (node == tail) {
                tail = node.prev;
            }
        }
    }

    public void clear(boolean asc) {
        head = tail = null;
        _ascending = asc;
    }

    public int count() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
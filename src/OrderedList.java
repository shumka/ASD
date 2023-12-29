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
            if (v1 instanceof Integer && v2 instanceof Integer) {
                return Integer.compare((Integer) v1, (Integer) v2);
            } else if (v1 instanceof String && v2 instanceof String) {
                return ((String) v1).compareTo((String) v2);
            } else {
                throw new IllegalArgumentException("Unsupported type");
            }
    }


    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node<T> current = head;
            Node<T> prev = null;

            while (current != null && ((_ascending && compare(current.value, value) < 0) ||  (!_ascending && compare(current.value, value) > 0))) {
                prev = current;
                current = current.next;
            }

            if (prev == null) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) {
                prev.next = newNode;
                newNode.prev = prev;
                tail = newNode;
            } else {
                prev.next = newNode;
                newNode.prev = prev;
                newNode.next = current;
                current.prev = newNode;
            }
        }
    }

    public Node<T> find(T val) {
        Node<T> current = head;

        while (current != null) {
            int cmp = compare(current.value, val);
            if (cmp == 0) {
                return current;
            } else if ((_ascending && cmp > 0) || (!_ascending && cmp < 0)) {
                break;
            }

            current = current.next;
        }

        return null;
    }

    public void delete(T val) {
        Node<T> nodeToDelete = find(val);

        if (nodeToDelete != null) {
            if (nodeToDelete.prev != null) {
                nodeToDelete.prev.next = nodeToDelete.next;
            } else {
                head = nodeToDelete.next;
            }

            if (nodeToDelete.next != null) {
                nodeToDelete.next.prev = nodeToDelete.prev;
            } else {
                tail = nodeToDelete.prev;
            }
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        head = null;
        tail = null;
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
        ArrayList<Node<T>> result = new ArrayList<>();
        Node<T> current = head;

        while (current != null) {
            result.add(current);
            current = current.next;
        }

        return result;
    }
}
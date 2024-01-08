//import java.util.*;
//
//public class Deque<T> {
//    private LinkedList<T> list;
//
//    public Deque() {
//        list = new LinkedList<>();
//    }
//
//    public void addFront(T item) {
//        list.addFirst(item);
//    }
//
//    public void addTail(T item) {
//        list.addLast(item);
//    }
//
//    public T removeFront() {
//        if (list.isEmpty()) {
//            return null;
//        }
//        return list.removeFirst();
//    }
//
//    public T removeTail() {
//        if (list.isEmpty()) {
//            return null;
//        }
//        return list.removeLast();
//    }
//
//    public int size() {
//        return list.size();
//    }
//
//    public boolean isPalindrome(String s) {
//        Deque<Character> deque = new Deque<>();
//        for (char c : s.toCharArray()) {
//            deque.addTail(c);
//        }
//        while (deque.size() > 1) {
//            if (deque.removeFront() != deque.removeTail()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//}
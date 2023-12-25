//import java.util.*;
//
//public class Stack<T>
//{
//    private LinkedList<T> list;
//
//    public Stack()
//    {
//        list = new LinkedList<>();
//        // инициализация внутреннего хранилища стека
//    }
//
//    public int size()
//    {
//        return list.size();
//    }
//
//    public T pop()
//    {
//        if (list.isEmpty())
//            return null;
//        return list.removeLast();
//        //return list.removeFirst();
//    }
//
//    public void push(T val)
//    {
//        list.addLast(val);
//        //list.addFirst(val);
//    }
//
//    public T peek()
//    {
//        if (list.isEmpty())
//            return null;
//        return list.getLast();
//        //return list.getFirst();
//    }
//
//    public boolean isBalanced(String s) {
//        Stack<Object> stack = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                stack.push(c);
//            } else if (c == ')') {
//                if (stack.size() == 0) {
//                    return false;
//                }
//                stack.pop();
//            }
//        }
//        return stack.size() == 0;
//
//    }
//
//}
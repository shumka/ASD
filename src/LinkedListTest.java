import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

    //LinkedList linkedlist;
    private Node a1 = new Node(11);
    private final Node a2 = new Node(22);
    private final Node a3 = new Node(33);
    private final Node a4 = new Node(44);
    private final Node a5 = new Node(55);
    private final Node a6 = new Node(66);
    private final Node a7 = new Node(77);
    private final Node a8 = new Node(73);
    private final Node a9 = new Node(73);
    private final Node a10 = new Node(73);

    private final Node a11 = new Node(222);

    private final Node a12 = new Node(333);


    @org.junit.jupiter.api.Test
    @DisplayName("Add/Find check in LinkedList")
    void Test_addInTail() {
        LinkedList list = new LinkedList();
        list.addInTail(a1);
        list.addInTail(a2);
        list.addInTail(a3);
//        list.addInTail(a4);
//        list.addInTail(a5);
//        list.addInTail(a6);
//        list.addInTail(a7);
//
//        list.addInTail(a8);
//        list.addInTail(a9);
//        list.addInTail(a10);

        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(a8);
        nodes.add(a9);
        nodes.add(a10);

        //Create and count
        assertEquals(3, list.count());
        list.remove(11);
        assertEquals(0, list.count());
        //Find in List
//        assertEquals(a1, list.find(11));
//        assertEquals(a2, list.find(22));
//        assertEquals(a3, list.find(33));
//        assertEquals(a4, list.find(44));
//        assertEquals(a5, list.find(55));
//        assertEquals(a6, list.find(66));
//        assertEquals(a7, list.find(77));

        //FindAll
        //assertEquals(nodes, list.findAll(73));

        //InserAfter
//        list.insertAfter(null,a11);
//        list.insertAfter(a10,a12);
//        assertEquals(12, list.count());
//        assertEquals(a11, list.find(222));
//        assertEquals(a12, list.find(333));

        //remove
//        list.remove(333);
//        assertEquals(11, list.count());

        //assertEquals(a7, list.find(77));

        //RemoveAll
//        list.removeAll(73);
//        assertEquals(8, list.count());
        //assertEquals(a8, list.find(73));

        //assertEquals(nodes, list.findAll(73));

//        //Clear
//        list.clear();
//        assertEquals(0, list.count());

    }



//    @org.junit.jupiter.api.Test
//    @DisplayName("Find in LinkedList")
//    void find() {
//        assertEquals(333, linkedlist.find(333));
//        assertEquals(444, linkedlist.find(444));
//        assertEquals(555, linkedlist.find(555));
//    }
//
//    @org.junit.jupiter.api.Test
//    @DisplayName("FindAll in LinkedList")
//    void findAll() {
//    }
//
//    @org.junit.jupiter.api.Test
//    @DisplayName("remove in LinkedList")
//    void remove() {
//    }
//
//    @org.junit.jupiter.api.Test
//    @DisplayName("removeAll in LinkedList")
//    void removeAll() {
//    }
//
//    @org.junit.jupiter.api.Test
//    @DisplayName("clear in LinkedList")
//    void clear() {
//    }
//
//    @org.junit.jupiter.api.Test
//    @DisplayName("count in LinkedList")
//    void count() {
//    }
//
//    @org.junit.jupiter.api.Test
//    @DisplayName("insertAfter in LinkedList")
//    void insertAfter() {
//    }
}
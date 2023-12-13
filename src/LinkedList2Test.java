import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {

    private final Node a1 = new Node(11);
    private final Node a2 = new Node(22);
    private final Node a3 = new Node(33);
    private final Node a4 = new Node(44);
    private final Node a5 = new Node(55);
    private final Node a6 = new Node(66);
    private final Node a7 = new Node(77);
    private final Node a8 = new Node(73);
    private final Node a9 = new Node(73);
    private final Node a10 = new Node(73);
    private final Node a11 = new Node(73);



    @Test
    void Test_addInTail() {
        LinkedList2 list = new LinkedList2();

        list.addInTail(a1);
        list.addInTail(a2);
        list.addInTail(a3);
        list.addInTail(a4);
        list.addInTail(a5);
        list.addInTail(a6);
        list.addInTail(a7);

        list.addInTail(a8);
        list.addInTail(a9);
        list.addInTail(a10);

        assertEquals(10, list.count());

        ArrayList<Node> nodes = new ArrayList<Node>();
        nodes.add(a8);
        nodes.add(a9);
        nodes.add(a10);

        assertTrue(list.remove(73));
        assertTrue(list.remove(73));
        assertTrue(list.remove(73));

        assertTrue(list.remove(77));
        assertTrue(list.remove(66));
        assertTrue(list.remove(55));
        assertTrue(list.remove(44));
        assertTrue(list.remove(33));
        assertTrue(list.remove(22));
        assertTrue(list.remove(11));

        assertFalse(list.remove(11));
        assertFalse(list.remove(73));

        //CHECKING FIND
        list.addInTail(a1);
        list.addInTail(a2);
        list.addInTail(a3);

        System.out.println(list.find(11));
        System.out.println(list.find(22));
        System.out.println(list.find(33));

        System.out.println(list.find(73));


        //FIND ALL
        list.findAll(56);

        list.findAll(73);
        list.addInTail(a8);
        list.addInTail(a4);
        list.addInTail(a9);
        list.addInTail(a5);
        list.findAll(73);

        //REMOVE_ALL
        list.removeAll(73);
        list.removeAll(11);
        list.removeAll(22);
        list.removeAll(33);
        list.removeAll(44);
        list.removeAll(55);

        list.removeAll(73);

        list.addInTail(a8);
        list.addInTail(a4);
        list.addInTail(a9);
        list.addInTail(a5);

        list.clear();

        assertEquals(0, list.count());

        list.addInTail(a4);
        list.addInTail(a8);
        list.addInTail(a5);
        list.addInTail(a9);
        list.addInTail(a1);


        list.insertAfter(null,a10);
        list.insertAfter(a1,a11);

        assertEquals(7, list.count());


    }

//    @Test
//    void find() {
//    }
//
//    @Test
//    void findAll() {
//    }
//
//    @Test
//    void remove() {
//    }
//
//    @Test
//    void removeAll() {
//    }
//
//    @Test
//    void clear() {
//    }
//
//    @Test
//    void count() {
//    }
//
//    @Test
//    void insertAfter() {
//    }
}
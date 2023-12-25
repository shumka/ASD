import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void addFront() {
        Deque testQ = new Deque<>();

        testQ.addFront("test1");
        testQ.addTail("test2");
        testQ.addTail("test3");
        testQ.addTail("test4");
        testQ.addFront("test5");
        testQ.addFront("test6");
        testQ.addFront("test7");

        assertEquals(7, testQ.size());
        assertEquals("test7",testQ.removeFront());
        assertEquals("test6",testQ.removeFront());
        assertEquals("test5",testQ.removeFront());
        assertEquals(4, testQ.size());
        assertEquals("test4",testQ.removeTail());
        assertEquals("test3",testQ.removeTail());
        assertEquals("test2",testQ.removeTail());
        assertEquals("test1",testQ.removeTail());
        assertEquals(null,testQ.removeTail());
        assertEquals(0, testQ.size());

        testQ.addTail("AAAMMAAA");

        assertEquals(true, testQ.isPalindrome("AAAMMAAA"));
        assertEquals(false, testQ.isPalindrome("AAAMMAAA12313"));
    }

    @Test
    void addTail() {
    }

    @Test
    void removeFront() {
    }

    @Test
    void removeTail() {
    }

    @Test
    void size() {
    }

    @Test
    void isPalindrome() {
    }
}
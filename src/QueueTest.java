//import static org.junit.jupiter.api.Assertions.*;
//
//class QueueTest {
//
//    @org.junit.jupiter.api.Test
//    void enqueue() {
//        Queue testQ = new Queue<>();
//
//        testQ.enqueue("test1");
//        testQ.enqueue("test2");
//        testQ.enqueue("test3");
//        testQ.enqueue("test4");
//        testQ.enqueue("test5");
//        testQ.enqueue("test6");
//        testQ.enqueue("test7");
//
//        assertEquals(7, testQ.size());
//        assertEquals("test1",testQ.dequeue());
//        assertEquals("test2",testQ.dequeue());
//        assertEquals("test3",testQ.dequeue());
//        assertEquals(4, testQ.size());
//        assertEquals("test4",testQ.dequeue());
//        assertEquals("test5",testQ.dequeue());
//        assertEquals("test6",testQ.dequeue());
//        assertEquals("test7",testQ.dequeue());
//        assertEquals(null,testQ.dequeue());
//        assertEquals(0, testQ.size());
//
//        testQ.enqueue("test1");
//        testQ.enqueue("test2");
//        testQ.enqueue("test3");
//        testQ.enqueue("test4");
//        testQ.enqueue("test5");
//        testQ.enqueue("test6");
//        testQ.enqueue("test7");
//        testQ.rotate(4);
//        testQ.rotate(1);
//
//
//
//    }
//
//    @org.junit.jupiter.api.Test
//    void dequeue() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void size() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void rotate() {
//    }
//}
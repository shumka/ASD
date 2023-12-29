import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest {

    @Test
    void compare() {
        OrderedList<Integer> list = new OrderedList<>(true);
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(9);
        assertEquals(5, list.count());

        list.find(7);
        list.add(7);
        list.delete(7);
        list.add(7);
        list.add(7);
        list.add(7);
        list.delete(7);
        list.add(7);




    }

    @Test
    void add() {
    }

    @Test
    void find() {
    }

    @Test
    void delete() {
    }

    @Test
    void clear() {
    }

    @Test
    void count() {
    }

    @Test
    void getAll() {
    }
}
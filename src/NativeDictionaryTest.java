import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

    @Test
    void TestisKey() {
        NativeDictionary<Integer> dict = new NativeDictionary<>(10, Integer.class);
        dict.put("key1", 1);
        assertTrue(dict.isKey("key1"));
        assertFalse(dict.isKey("key2"));
    }

    @Test
    void Testput() {
        NativeDictionary<Integer> dict = new NativeDictionary<>(10, Integer.class);
        dict.put("key1", 1);
        dict.put("key2", 2);
        dict.put("key1", 3);
        assertEquals(3, dict.get("key1").intValue());
        assertEquals(2, dict.get("key2").intValue());
    }

    @Test
    void Testget() {
        NativeDictionary<Integer> dict = new NativeDictionary<>(10, Integer.class);
        dict.put("key1", 1);
        assertEquals(1, dict.get("key1").intValue());
        assertNull(dict.get("key2"));
    }
}
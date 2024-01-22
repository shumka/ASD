import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NativeCacheTest {

    @Test
    public void testPutAndGet() {
        NativeCache<String> cache = new NativeCache<>(5);
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        assertEquals("value1", cache.get("key1"));
        assertEquals("value2", cache.get("key2"));
        assertEquals("value3", cache.get("key3"));
        assertNull(cache.get("key4"));
    }

    @Test
    public void testIsKey() {
        NativeCache<String> cache = new NativeCache<>(5);
        cache.put("key1", "value1");

        assertTrue(cache.isKey("key1"));
        assertFalse(cache.isKey("key2"));
    }

    @Test
    public void testEviction() {
        NativeCache<String> cache = new NativeCache<>(3);
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        cache.put("key4", "value4");

        assertNull(cache.get("key1"));
        assertEquals("value2", cache.get("key2"));
        assertEquals("value3", cache.get("key3"));
        assertEquals("value4", cache.get("key4"));
    }

    @Test
    public void testHits() throws InterruptedException {
        NativeCache<String> cache = new NativeCache<>(3);
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");


        cache.get("key1");
        cache.get("key1");
        cache.get("key1");
        cache.get("key2");
        cache.get("key2");
        cache.get("key3");


        cache.put("key7", "value7");

        cache.get("key7");
        cache.get("key7");
        assertNull(cache.get("key3"));
        assertEquals("value1", cache.get("key1"));
        assertEquals("value2", cache.get("key2"));
        assertEquals("value7", cache.get("key7"));
    }

    @Test
    public void testHitsWithEviction() throws InterruptedException {
        NativeCache<String> cache = new NativeCache<>(3);
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");

        // Получаем элементы несколько раз
        cache.get("key1");
        cache.get("key1");
        cache.get("key2");

        // Добавляем новый элемент, который должен вытеснить один из существующих
        cache.put("key7", "value7");

        // Проверяем, что старый элемент был вытеснен
        assertNull(cache.get("key3")); // key3 должен быть вытеснен
        assertEquals("value1", cache.get("key1")); // key1 должен остаться в кэше
        assertEquals("value2", cache.get("key2")); // key2 должен остаться в кэше
        assertEquals("value7", cache.get("key7")); // Новый элемент key7 должен быть добавлен

        // Проверяем, что старый элемент key1 не был вытеснен раньше времени
        cache.get("key1");
        cache.put("key8", "value8"); // В этот момент key1 должен быть вытеснен
        assertNull(cache.get("key7")); // key1 должен быть вытеснен
    }

}
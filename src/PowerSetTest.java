import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerSetTest {

    @Test
    public void testPutAndGet() {
        PowerSet set = new PowerSet();
        set.put("test");
        assertTrue(set.get("test"));
        assertFalse(set.get("nonexistent"));
    }

    @Test
    public void testRemove() {
        PowerSet set = new PowerSet();
        set.put("test");
        assertTrue(set.remove("test"));
        assertFalse(set.remove("nonexistent"));
    }

    @Test
    public void testIntersection() {
        PowerSet set1 = new PowerSet();
        set1.put("test1");
        set1.put("test2");
        PowerSet set2 = new PowerSet();
        set2.put("test2");
        set2.put("test3");
        PowerSet intersection = set1.intersection(set2);
        assertTrue(intersection.get("test2"));
        assertFalse(intersection.get("test1"));
        assertFalse(intersection.get("test3"));
    }

    @Test
    public void testUnion() {
        PowerSet set1 = new PowerSet();
        set1.put("test1");
        PowerSet set2 = new PowerSet();
        set2.put("test2");
        PowerSet union = set1.union(set2);
        assertTrue(union.get("test1"));
        assertTrue(union.get("test2"));
    }

    @Test
    public void testDifference() {
        PowerSet set1 = new PowerSet();
        set1.put("test1");
        set1.put("test2");
        PowerSet set2 = new PowerSet();
        set2.put("test2");
        PowerSet difference = set1.difference(set2);
        assertFalse(difference.get("test2"));
        assertTrue(difference.get("test1"));
    }

    @Test
    public void testIsSubset() {
        PowerSet set1 = new PowerSet();
        set1.put("test1");
        set1.put("test2");
        PowerSet set2 = new PowerSet();
        set2.put("test2");
        assertTrue(set1.isSubset(set2));
        set2.put("test3");
        assertFalse(set1.isSubset(set2));
    }
}
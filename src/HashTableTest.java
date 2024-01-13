//import org.junit.Test;
//
//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class HashTableTest {
//
//    @Test
//    public void testHashFun() {
//        HashTable hashTable = new HashTable(17, 3);
//        hashTable.put("test");
//        hashTable.put("test1");
//        hashTable.put("test2");
//        hashTable.put("test3");
//        int value = hashTable.hashFun("test");
//        assertEquals(16, hashTable.seekSlot("test"));
//        assertEquals(13, hashTable.find("test"));
//        assertEquals(-1, hashTable.find("test777"));
//
//    }
//
//}
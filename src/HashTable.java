//public class HashTable {
//    public int size;
//    public int step;
//    public String [] slots;
//
//    public HashTable(int sz, int stp) {
//        size = sz;
//        step = stp;
//        slots = new String[size];
//        for(int i=0; i<size; i++) slots[i] = null;
//    }
//
//    public int hashFun(String value) {
//        return Math.abs(value.hashCode()) % size;
//    }
//
//    public int seekSlot(String value) {
//        int index = hashFun(value);
//        int firstIndex = index;
//        while (slots[index] != null) {
//            index = (index + step) % size;
//            if (index == firstIndex) {
//                return -1;
//            }
//        }
//        return index;
//    }
//
//    public int put(String value) {
//        int index = seekSlot(value);
//        if (index != -1) {
//            slots[index] = value;
//        }
//        // возвращается индекс слота или -1
//        // если из-за коллизий элемент не удаётся разместить
//        return index;
//    }
//
//    public int find(String value) {
//        // находит индекс слота со значением, или -1
//        int index = hashFun(value);
//        if (value.equals(slots[index])) {
//            return index;
//        }
//        int firstIndex = index;
//        while (index != -1 && !value.equals(slots[index])) {
//            index = (index + step) % size;
//            if (index == firstIndex) {
//                return -1;
//            }
//        }
//        return index;
//    }
//}
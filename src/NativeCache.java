public class NativeCache<T> {
    private int size;
    private String[] slots;
    private T[] values;
    private int[] hits;

    public NativeCache(int sz) {
        size = sz;
        slots = new String[size];
        values = (T[]) new Object[size];
        hits = new int[size];
    }

    public int hashFun(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    public boolean isKey(String key) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            if (slots[index] != null && slots[index].equals(key)) {
                hits[index]++;
                return true;
            }
            index = (index + 1) % size;
        }
        return false;
    }

    public void put(String key, T value) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            if (slots[index] == null || slots[index].equals(key)) {
                slots[index] = key;
                values[index] = value;
                hits[index] = 0;
                return;
            }
            index = (index + 1) % size;
        }

        // Если нет места, вытесняем элемент с наименьшим количеством обращений
        int minHitsIndex = 0;
        for (int i = 1; i < size; i++) {
            if (hits[i] < hits[minHitsIndex]) {
                minHitsIndex = i;
            }
        }
        slots[minHitsIndex] = key;
        values[minHitsIndex] = value;
        hits[minHitsIndex] = 0;
    }

    public T get(String key) {
        int index = hashFun(key);
        for (int i = 0; i < size; i++) {
            if (slots[index] != null && slots[index].equals(key)) {
                hits[index]++;
                return values[index];
            }
            index = (index + 1) % size;
        }
        return null;
    }
}
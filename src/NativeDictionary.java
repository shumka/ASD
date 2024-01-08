import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        // всегда возвращает корректный индекс слота
        return Math.abs(key.hashCode() % size);
    }

    public boolean isKey(String key)
    {
        // возвращает true если ключ имеется,
        // иначе false
        int index = hashFun(key);
        while (slots[index] != null) {
            if (slots[index].equals(key)) {
                return true;
            }
            index = (index + 1) % size;
        }
        return false;
    }

    public void put(String key, T value)
    {
        // гарантированно записываем
        // значение value по ключу key
        int index = hashFun(key);
        while (slots[index] != null) {
            if (slots[index].equals(key)) {
                values[index] = value;
                return;
            }
            index = (index + 1) % size;
        }
        slots[index] = key;
        values[index] = value;
    }

    public T get(String key)
    {
        // возвращает value для key,
        // или null если ключ не найден
        int index = hashFun(key);
        while (slots[index] != null) {
            if (slots[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % size;
        }
        return null;
    }
}
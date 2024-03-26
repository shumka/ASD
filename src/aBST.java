import java.util.*;

class aBST {
    public Integer Tree[]; // массив ключей
    private int depth;

    public aBST(int depth) {
        this.depth = depth;
        // правильно рассчитаем размер массива для дерева глубины depth:
        int tree_size = (int) Math.pow(2, depth + 1) - 1;
        Tree = new Integer[tree_size];
        Arrays.fill(Tree, null);
    }

    public Integer FindKeyIndex(int key) {
        int index = 0;
        while (index < Tree.length) {
            if (Tree[index] == null)
                return null; // не найден
            if (Tree[index] == key)
                return index; // найден
            if (key < Tree[index])
                index = 2 * index + 1; // двигаемся влево
            else
                index = 2 * index + 2; // двигаемся вправо
        }
        return null; // не найден
    }

    public int AddKey(int key) {
        int index = 0;
        while (index < Tree.length) {
            if (Tree[index] == null) {
                Tree[index] = key;
                return -index; // отрицательное значение индекса, если добавлено в пустой слот
            }
            if (Tree[index] == key)
                return index; // ключ уже существует
            if (key < Tree[index])
                index = 2 * index + 1; // двигаемся влево
            else
                index = 2 * index + 2; // двигаемся вправо
        }
        return -1; // не удалось добавить, дерево заполнено
    }
}
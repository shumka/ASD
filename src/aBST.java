import java.util.*;

class aBST {
    public Integer Tree[]; // массив ключей

    public aBST(int depth) {
        // правильно рассчитайте размер массива для дерева глубины depth:
        int tree_size = (int) Math.pow(2, depth + 1) - 1; // 2^(depth+1) - 1
        Tree = new Integer[tree_size];
        Arrays.fill(Tree, null); // Initialize all elements to null
    }

    public Integer FindKeyIndex(int key) {
        int currentIndex = 0; // Start at the root
        while (currentIndex < Tree.length) {
            Integer currentValue = Tree[currentIndex];
            if (currentValue == null) {
                return -currentIndex - 1; // Found an empty slot
            } else if (key == currentValue) {
                return currentIndex; // Key found
            } else if (key < currentValue) {
                currentIndex = 2 * currentIndex + 1; // Go to left child
            } else {
                currentIndex = 2 * currentIndex + 2; // Go to right child
            }
        }
        return null; // Key not found and no empty slots
    }

    public int AddKey(int key) {
        // добавляем ключ в массив
        int index = FindKeyIndex(key);
        if (index >= 0) {
            return index; // Key already exists
        } else if (index < 0) {
            index = -index - 1; // Convert negative index to actual index
            Tree[index] = key;
            return index; // Key added successfully
        } else {
            return -1; // Tree is full
        }
    }
}
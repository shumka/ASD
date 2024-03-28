import java.util.*;

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        // Вычисляем размер массива на основе количества элементов в a
        HeapArray = new int[a.length];
        // Копируем элементы из входного массива в кучу
        System.arraycopy(a, 0, HeapArray, 0, a.length);
        // Просеиваем элементы, чтобы соблюсти свойства кучи
        for (int i = HeapArray.length / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public int GetMax() {
        if (HeapArray == null || HeapArray.length == 0) {
            return -1; // Если куча пуста
        }
        int max = HeapArray[0];
        // Перемещаем последний элемент в корень и просеиваем его вниз
        HeapArray[0] = HeapArray[HeapArray.length - 1];
        HeapArray = Arrays.copyOf(HeapArray, HeapArray.length - 1);
        siftDown(0);
        return max;
    }

    public boolean Add(int key) {
        if (HeapArray == null) {
            HeapArray = new int[1];
            HeapArray[0] = key;
            return true;
        }
        // Увеличиваем размер массива на 1 и добавляем новый элемент в конец
        HeapArray = Arrays.copyOf(HeapArray, HeapArray.length + 1);
        HeapArray[HeapArray.length - 1] = key;
        // Просеиваем новый элемент вверх
        siftUp(HeapArray.length - 1);
        return true;
    }

    private void siftDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        if (leftChild < HeapArray.length && HeapArray[leftChild] > HeapArray[largest]) {
            largest = leftChild;
        }
        if (rightChild < HeapArray.length && HeapArray[rightChild] > HeapArray[largest]) {
            largest = rightChild;
        }
        if (largest != index) {
            swap(index, largest);
            siftDown(largest);
        }
    }

    private void siftUp(int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && HeapArray[index] > HeapArray[parent]) {
            swap(index, parent);
            siftUp(parent);
        }
    }

    private void swap(int i, int j) {
        int temp = HeapArray[i];
        HeapArray[i] = HeapArray[j];
        HeapArray[j] = temp;
    }
}
import java.util.*;

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        // Вычисляем размер массива на основе глубины
        int size = (int) Math.pow(2, depth) - 1;
        HeapArray = new int[size];
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
        siftDown(0);
        return max;
    }

    public boolean Add(int key) {
        if (HeapArray == null || HeapArray.length == 0) {
            return false; // Если куча не инициализирована или заполнена
        }
        // Ищем первый свободный слот и добавляем новый элемент
        for (int i = 0; i < HeapArray.length; i++) {
            if (HeapArray[i] == 0) {
                HeapArray[i] = key;
                siftUp(i);
                return true;
            }
        }
        return false; // Если куча заполнена
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
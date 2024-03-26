import org.junit.Test;
import static org.junit.Assert.*;

public class aBSTTest {

    @Test
    public void testAddKeyAndFindKeyIndex() {
        // Создаем дерево глубины 3
        aBST tree = new aBST(3);

        // Добавляем ключи
        assertEquals(-7, tree.AddKey(8)); // добавлено в пустой слот
        assertEquals(-3, tree.AddKey(3)); // добавлено в пустой слот
        assertEquals(-15, tree.AddKey(10)); // добавлено в пустой слот
        assertEquals(-1, tree.AddKey(1)); // добавлено в пустой слот
        assertEquals(-5, tree.AddKey(6)); // добавлено в пустой слот
        assertEquals(-13, tree.AddKey(9)); // добавлено в пустой слот
        assertEquals(-11, tree.AddKey(12)); // добавлено в пустой слот

        // Проверяем поиск
        assertEquals(4, (int) tree.FindKeyIndex(6)); // индекс найденного ключа
        assertNull(tree.FindKeyIndex(11)); // ключ не найден
    }

    @Test
    public void testAddKeyWhenTreeIsFull() {
        // Создаем дерево глубины 1 для простоты
        aBST tree = new aBST(1);

        // Заполняем дерево
        tree.AddKey(1);
        tree.AddKey(2);
        tree.AddKey(3);

        // Добавляем ключ, когда дерево уже заполнено
        assertEquals(-1, tree.AddKey(4)); // не удалось добавить
    }

    @Test
    public void testFindKeyIndexWhenTreeIsEmpty() {
        // Создаем пустое дерево
        aBST tree = new aBST(2);

        // Поиск в пустом дереве
        assertNull(tree.FindKeyIndex(5)); // ключ не найден
    }
}
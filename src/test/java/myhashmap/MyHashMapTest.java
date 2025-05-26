package myhashmap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void testPutAndGet() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "one");
        assertEquals("one", map.get(1), "Неверное значение");
    }

    @Test
    void testOverwriteValue() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "one");
        map.put(1, "new");
        assertEquals("new", map.get(1), "Не обновилось значение");
    }

    @Test
    void testRemove() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "one");
        map.remove(1);
        assertNull(map.get(1), "Удаление не сработало");
        assertEquals(0, map.size(), "Размер не уменьшился");
    }

    @Test
    void testContainsKey() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(5, "five");
        assertTrue(map.containsKey(5), "Нет ключа 5");
        assertFalse(map.containsKey(10), "Есть лишний ключ");
    }

    @Test
    void testSize() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        assertEquals(0, map.size(), "Должен быть 0");
        map.put(1, "one");
        assertEquals(1, map.size(), "Должен быть 1");
        map.put(2, "two");
        assertEquals(2, map.size(), "Должен быть 2");
        map.put(1, "updated");
        assertEquals(2, map.size(), "Размер не должен меняться");
    }

    @Test
    void testPutNullKey() {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put(null, "nullValue");
        assertEquals("nullValue", map.get(null), "Нет значения по null");
        assertTrue(map.containsKey(null), "Нет ключа null");
    }

    @Test
    void testResizePreservesValues() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(i, "v" + i);
        }
        for (int i = 0; i < 20; i++) {
            assertEquals("v" + i, map.get(i), "Потеря данных при resize");
        }
        assertEquals(20, map.size(), "Неправильный размер");
    }
}

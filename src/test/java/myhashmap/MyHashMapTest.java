package myhashmap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void testPutAndGet() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "one");
        assertEquals("one", map.get(1));
    }

    @Test
    void testOverwriteValue() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "one");
        map.put(1, "new");
        assertEquals("new", map.get(1));
    }

    @Test
    void testRemove() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "one");
        map.remove(1);
        assertNull(map.get(1));
    }

    @Test
    void testContainsKey() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(5, "five");
        assertTrue(map.containsKey(5));
        assertFalse(map.containsKey(10));
    }

    @Test
    void testSize() {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        assertEquals(0, map.size());
        map.put(1, "one");
        assertEquals(1, map.size());
    }
}

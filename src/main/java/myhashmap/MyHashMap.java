package myhashmap;

public class MyHashMap <K, V>  {
    private static final int DEFAULT_CAPACITY = 16;

    private Entry<K, V>[] table;
    private int size;

    public MyHashMap() {
        this.table = new Entry[DEFAULT_CAPACITY];
    }

    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put (K key, V value) {
        int index = Math.abs(key.hashCode() % table.length);
        Entry<K, V> current = table[index];

        if (current == null) {
            table[index] = new Entry<>(key, value);
            size++;
            return;
        }

        Entry<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }

        prev.next = new Entry<>(key, value);
        size++;
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode() % table.length);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = Math.abs(key.hashCode() % table.length);
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;

                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean containsKey(K key) {
        int index = Math.abs(key.hashCode() % table.length);
        Entry<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public int size() {
        return size;
    }
}

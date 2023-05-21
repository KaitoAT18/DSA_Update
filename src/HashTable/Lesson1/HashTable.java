package HashTable.Lesson1;

import java.util.Map;
import java.util.Objects;

public class HashTable <K, V>{
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private int count;      // tổng số phần tử trong bảng băm
    private Entry<?, ?>[] table;        // dữ liệu của bảng băm
    private int threshold;      // ngưỡng
    private float loadFactor;       // load factor
    private int modCount = 0;       // số lần bảng băm sửa đổi cấu trúc, ví dụ băm lại

    public HashTable(int capacity, float loadFactor) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Illegal Load: " + loadFactor);
        }
        if (capacity == 0) {
            capacity = 1;
        }
        this.loadFactor = loadFactor;
        table = new Entry<?, ?>[capacity];
        threshold = (int) Math.min(capacity * loadFactor, MAX_ARRAY_SIZE + 1);
    }

    public HashTable(int capacity) {
        this(capacity, 0.75f);
    }

    public HashTable() {
        this(11, 0.75f);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private boolean contains(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
        Entry<?, ?>[] tab = table;
        for (int i = tab.length - 1; i >= 0; i--) {
            for (var e = tab[i]; e != null; e = e.next) {
                if (e.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        return contains(value);
    }

    public boolean containsKey(Object key) {
        Entry<?, ?>[] tab = table;
        int hash = key.hashCode();
        int index = (hash & 0x7fffffff) % tab.length;
        for (var e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Phương thức lấy value tương ứng với key
     *
     * @param key khoá cần lấy giá trị tương ứng trong bảng băm
     * @return giá trị value liên kết với key
     */
    public V get(Object key) {
        Entry<?, ?>[] tab = table;      // lấy bảng băm
        int hash = key.hashCode();      // lấy mã băm của key
        int index = (hash & 0x7fffffff) % tab.length;        // lấy chỉ số trong bảng băm
        for (var e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {        // tìm thấy
                return (V) e.value;     // trả về giá trị value
            }
        }
        return null;        // không tìm thấy, trả về null
    }

    /**
     * Phương thức thêm mới một cặp key-value vào bảng băm
     *
     * @param key   khoá
     * @param value giá trị liên kết với khoá
     * @return  giá trị cũ tại vị trí index
     */
    public V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }
        Entry<?, ?>[] tab = table;
        int hash = key.hashCode();
        int index = (hash & 0x7fffffff) % tab.length;
        var entry = (Entry<K, V>) tab[index];
        for (;entry != null; entry = entry.next) {
            if (entry.hash == hash && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }
        addEntry(hash, key, value, index);
        return null;
    }

    /**
     * Phương thức thêm mới entry vào bảng băm
     *
     * @param hash      mã băm của key
     * @param key       khoá
     * @param value     giá trị liên kết với khoá
     * @param index     vị trí
     */
    private void addEntry(int hash, K key, V value, int index) {
        Entry<?, ?>[] tab = table;
        if (count >= threshold) {
            rehash();       // băm lại
            tab = table;
            hash = key.hashCode();          // lấy mã băm
            index = (hash & 0x7fffffff) % tab.length;       // lấy chỉ số
        }
        var e = (Entry<K, V>) tab[index];       // phần tử next của entry mới
        tab[index] = new Entry<>(hash, key, value, e);
        count++;
        modCount++;
    }

    /**
     * Phương thức dùng để băm lại các phần tử trong bảng băm cũ
     */
    private void rehash() {
        // implement later ^.^
    }

    private static class Entry<K, V> implements Map.Entry<K, V> {
        final int hash;     // mã băm
        final K key;        // khoá
        V value;            // giá trị liên kết với khoá
        Entry<K, V> next;   // con trỏ next

        protected Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        protected Object clone() {
            return new Entry<>(hash, key ,value,
                    (next == null ? null : (Entry<K, V>) next.clone()));
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            if (value == null) {
                throw new NullPointerException();
            }
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) return false;
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            return (key == null ? e.getKey() == null : key.equals(e.getKey())) &&
                    (value == null ? e.getValue() == null : value.equals(e.getValue()));
        }

        @Override
        public int hashCode() {
            return hash ^ Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}

package leetcode.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache_146 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache_146(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        var lruCache146 = new LRUCache_146(2);
        lruCache146.put(1, 1);
        lruCache146.put(2, 2);
        lruCache146.get(1);
        lruCache146.put(3, 3);
        lruCache146.get(2);
        lruCache146.put(4, 4);
        lruCache146.get(1);

    }
}

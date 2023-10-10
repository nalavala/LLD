package com.learn.lld.cache.core.storage;


import com.learn.lld.cache.core.CacheFullException;
import com.learn.lld.cache.core.CacheMissException;

import java.util.HashMap;

// TODO : make this thread safe
public class InMemoryCacheStorage<K, V> implements ICacheStorage<K, V> {

    private HashMap<K, V> map;
    private int capacity;

    public InMemoryCacheStorage(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    @Override
    public void put(K key, V value) throws CacheFullException {
        if(map.size() == capacity) {
            throw new CacheFullException();
        }

        map.put(key, value);
    }

    @Override
    public V get(K key) throws CacheMissException {
        V value = map.get(key);
        if(value == null) {
            throw new CacheMissException("Key is not found in cache");
        }
        return value;
    }

    @Override
    public V remove(K key) {
        if(map.containsKey(key)) {
            return map.remove(key);
        }

        return null;

    }
}

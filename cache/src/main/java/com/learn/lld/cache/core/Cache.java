package com.learn.lld.cache.core;


import com.learn.lld.cache.core.eviction.EvictionStrategy;
import com.learn.lld.cache.core.storage.ICacheStorage;

public class Cache<K, V> implements ICache<K, V> {

    private EvictionStrategy<K> evictionStrategy;

    private ICacheStorage<K, V> cacheStorage;

    public Cache(EvictionStrategy<K> evictionStrategy, ICacheStorage<K, V> cacheStorage) {
        this.evictionStrategy = evictionStrategy;
        this.cacheStorage = cacheStorage;
    }


    @Override
    public V get(K key) {
        try {
            V value = cacheStorage.get(key);
            evictionStrategy.keyAccessed(key);
            return value;
        } catch (CacheMissException e) {
            System.out.println("Key is not present in cache");
            return null;
        }


    }

    @Override
    public void put(K key, V value) {

        try {
            cacheStorage.put(key, value);
            evictionStrategy.keyAccessed(key);
        } catch (CacheFullException e) {
            System.out.println("storage id full. Will try to evict.");
            K evictionKey = evictionStrategy.getEvictionKey();
            if(evictionKey == null) {
                // properly handle
            }
            evictionStrategy.removeKey(evictionKey);
            cacheStorage.remove(key);
            System.out.println("Creating space by evicting item..." + evictionKey);
            put(key, value);
        }

    }

}

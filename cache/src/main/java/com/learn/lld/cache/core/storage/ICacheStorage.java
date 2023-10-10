package com.learn.lld.cache.core.storage;


import com.learn.lld.cache.core.CacheFullException;
import com.learn.lld.cache.core.CacheMissException;

public interface ICacheStorage<K, V> {

    void put(K key, V value) throws CacheFullException;
    V get (K key) throws CacheMissException;
    V remove(K key);
}

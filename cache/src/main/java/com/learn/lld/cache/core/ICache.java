package com.learn.lld.cache.core;

public interface ICache<K, V> {

    V get(K key);
    void put(K key, V value);
}

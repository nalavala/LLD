package com.learn.lld.cache.core.eviction;

/**
 * Strategy for implement Cache eviction if cache is full
 * @param <K>
 */
public interface EvictionStrategy<K> {

    K getEvictionKey();

    void keyAccessed(K key);

    void removeKey(K key);
}

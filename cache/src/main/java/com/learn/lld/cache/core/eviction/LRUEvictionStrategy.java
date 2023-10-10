package com.learn.lld.cache.core.eviction;

import com.learn.lld.cache.core.datastructure.DoublyLinkedList;

public class LRUEvictionStrategy<K> implements EvictionStrategy<K> {

    private DoublyLinkedList<K> linkedList = new DoublyLinkedList<>();
    @Override
    public K getEvictionKey() {
        return linkedList.getFirst();
    }

    @Override
    public void keyAccessed(K key) {
        linkedList.moveKeyToTheEnd(key);
    }

    @Override
    public void removeKey(K key) {
        linkedList.removeNode(key);
    }
}

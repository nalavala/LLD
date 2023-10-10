package com.learn.lld.cache.core.datastructure;

import java.util.HashMap;
import java.util.Map;

public class DoublyLinkedList<T> {

    private Node<T> head = null;
    private Node<T> last = null;

    Map<T, Node<T>> map = new HashMap<>();


    public T getFirst() {
        if (head == null) {
            // Throw error
        }

        return head.getValue();
    }


    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if(head == null) {
            head = node;
            last = node;
        } else {
            Node<T> next = head.getNext();
            node.setNext(next);
            next.setPrevious(node);
            head.setNext(node);
            node.setPrevious(head);
        }
        map.put(value, node);

    }
    public void addLast(T value) {
        Node<T> node = new Node<>(value);

        if (last == null) {
            head = node;
        } else {
            last.setNext(node);
            node.setPrevious(last);
        }
        last = node;
        map.put(value, node);
    }


    public void removeNode(T node) {
        removeNode(map.get(node));
    }

    public void removeNode(Node<T> node) {
        if(node == head) {
            removeFirst();
        } else if(node == last) {
            last = last.getPrevious();
            last.setNext(null);
        } else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
        }

        map.remove(node.getValue());
    }


    public void removeFirst() {
        map.remove(head.getValue());
        head = head.getNext();
        head.setPrevious(null);

    }



    public void moveKeyToTheEnd(T value) {
        if(!map.containsKey(value)) {
            // Throw error
        }

        Node<T> node = map.get(value);
        removeNode(node);
        addLast(node.getValue());

    }



}

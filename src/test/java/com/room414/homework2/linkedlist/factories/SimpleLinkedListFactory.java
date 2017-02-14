package com.room414.homework2.linkedlist.factories;

import com.room414.homework2.linkedlist.implementation.SimpleLinkedList;
import com.room414.homework2.linkedlist.interfaces.MyLinkedList;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class SimpleLinkedListFactory<T> extends LinkedListFactory<T> {
    @Override
    public MyLinkedList<T> create() {
        return new SimpleLinkedList<>();
    }

    @Override
    public MyLinkedList<T> create(Iterable<? extends T> other) {
        return new SimpleLinkedList<>(other);
    }
}

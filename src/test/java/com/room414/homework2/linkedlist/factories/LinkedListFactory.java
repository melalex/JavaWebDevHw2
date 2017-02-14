package com.room414.homework2.linkedlist.factories;

import com.room414.homework2.linkedlist.interfaces.MyLinkedList;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public abstract class LinkedListFactory<T> {
    public abstract MyLinkedList<T> create();
    public abstract MyLinkedList<T> create(Iterable<? extends T> another);
}

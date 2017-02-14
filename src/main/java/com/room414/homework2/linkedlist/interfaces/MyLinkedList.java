package com.room414.homework2.linkedlist.interfaces;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public interface MyLinkedList<T> extends Iterable<T> {
    int size();
    T[] asArray();

    void addLast(T value);
    void addLast(Iterable<? extends T> another);
    void addFirst(T value);
    void addFirst(Iterable<? extends T> another);
    void insertAfter(T value, int index);
    void insertAfter(Iterable<? extends T> another, int index);
    void insertBefore(T value, int index);
    void insertBefore(Iterable<? extends T> another, int index);

    T getFirst();
    T getLast();
    T get(int index);

    void setFirst(T value);
    void setLast(T value);
    void set(T value, int index);

    void removeFirst();
    void removeLast();
    void remove(int index);
    void removeFirst(T value);
    void removeLast(T value);
    void removeAll(T value);
    void clear();

    T popFirst();
    T popLast();
    T pop(int index);
}

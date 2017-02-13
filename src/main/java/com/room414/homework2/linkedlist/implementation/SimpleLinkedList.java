package com.room414.homework2.linkedlist.implementation;

import com.room414.homework2.linkedlist.interfaces.MyLinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class SimpleLinkedList<T> implements MyLinkedList<T> {
    

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addLast(T value) {

    }

    @Override
    public void addLast(MyLinkedList<? extends T> another) {

    }

    @Override
    public void addFirst(T value) {

    }

    @Override
    public void addFirst(MyLinkedList<? extends T> another) {

    }

    @Override
    public void insertAfter(T value, int index) {

    }

    @Override
    public void insertAfter(MyLinkedList<? extends T> another) {

    }

    @Override
    public void insertBefore(T value, int index) {

    }

    @Override
    public void insertBefore(MyLinkedList<? extends T> another, int index) {

    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void setFirst(T value) {

    }

    @Override
    public void setLast(T value) {

    }

    @Override
    public void set(T value, int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst(T value) {

    }

    @Override
    public void removeLast(T value) {

    }

    @Override
    public void removeAll(T value) {

    }

    @Override
    public void clear() {

    }

    @Override
    public T popFirst() {
        return null;
    }

    @Override
    public T popLast() {
        return null;
    }

    @Override
    public T pop(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> consumer) {

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

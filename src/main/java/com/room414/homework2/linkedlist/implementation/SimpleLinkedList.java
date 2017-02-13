package com.room414.homework2.linkedlist.implementation;

import com.room414.homework2.linkedlist.interfaces.MyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class SimpleLinkedList<T> implements MyLinkedList<T> {
    private static final int HASH_CODE_INITIAL_VALUE = 17;
    private static final int HASH_CODE_MULTIPLIER = 37;

    private static final class Node<T> {
        private T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }
    }

    private static final class SimpleLinkedListIterator<T> implements Iterator<T> {
        Node<T> runner;

        private SimpleLinkedListIterator(Node<T> first) {
            runner = first;
        }

        @Override
        public boolean hasNext() {
            return runner.next != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T current = runner.value;
                runner = runner.next;
                return current;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super T> consumer) {

        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public SimpleLinkedList() {

    }

    public SimpleLinkedList(Iterable<? extends T> another) {
        if (another != null) {
            for (T value: another) {
                addLast(value);
            }
        }
    }

    private Node<T> getNodeAtIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        Node<T> node = first;

        for (int i = 0; i <= index; i++) {
            node = node.next;
        }

        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T[] asArray() {
        Object[] array = new Object[size];
        Node<T> runner = first;
        for (int i = 0; i < size; i++) {
            array[i] = runner.value;
            runner = runner.next;
        }
        return (T[])array;
    }

    @Override
    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);

        if (size == 0) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    @Override
    public void addLast(Iterable<? extends T> another) {
        if (another == null) {
            throw new IllegalArgumentException("another can't be null");
        }

        SimpleLinkedList<T> appended = new SimpleLinkedList<>(another);
        size += appended.size;

        if (appended.size != 0) {
            if (size == 0) {
                last = appended.last;
                first = appended.first;
            } else {
                last.next = appended.first;
                last = appended.last;
            }
        }
    }

    @Override
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);

        if (size() == 0) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }

        size++;
    }

    @Override
    public void addFirst(Iterable<? extends T> another) {
        if (another == null) {
            throw new IllegalArgumentException("another can't be null");
        }

        SimpleLinkedList<T> appended = new SimpleLinkedList<>(another);
        size += appended.size();

        if (appended.size != 0) {
            if (size == 0) {
                last = appended.last;
                first = appended.first;
            } else {
                appended.last.next = this.first;
                first = appended.first;
            }
        }
    }

    @Override
    public void insertAfter(T value, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        Node<T> nodeBefore = getNodeAtIndex(index);
        Node<T> newNode = new Node<>(value);

        newNode.next = nodeBefore.next;
        nodeBefore.next = newNode;

        size++;
    }

    @Override
    public void insertAfter(Iterable<? extends T> another, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        if (another == null) {
            throw new IllegalArgumentException("another can't be null");
        }

        SimpleLinkedList<T> appended = new SimpleLinkedList<>(another);
        size += appended.size;

        if (appended.size != 0) {
            Node<T> nodeBefore = getNodeAtIndex(index);

            appended.last = nodeBefore.next;
            appended.first = nodeBefore;
        }
    }

    @Override
    public void insertBefore(T value, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        Node<T> newNode = new Node<>(value);

        if (index != 0) {
            insertAfter(value, index - 1);
        } else {
            newNode.next = first;
            first = newNode;
            size++;
        }
    }

    @Override
    public void insertBefore(Iterable<? extends T> another, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        if (another == null) {
            throw new IllegalArgumentException("another can't be null");
        }

        if (index == 0) {
            insertAfter(another, index - 1);
        } else {
            SimpleLinkedList<T> appended = new SimpleLinkedList<>(another);

            if (size != 0 && appended.size() != 0) {
                size += appended.size;

                appended.last.next = this.first;
                this.first = appended.first;
            }
        }
    }

    @Override
    public T getFirst() {
        return first.value;
    }

    @Override
    public T getLast() {
        return last.value;
    }

    @Override
    public T get(int index) {
        return getNodeAtIndex(index).value;
    }

    @Override
    public void setFirst(T value) {
        if (first == null) {
            first = last = new Node<>(value);
            size++;
        } else {
            first.value = value;
        }
    }

    @Override
    public void setLast(T value) {
        if (last == null) {
            first = last = new Node<>(value);
            size++;
        } else {
            last.value = value;
        }
    }

    @Override
    public void set(T value, int index) {
        Node<T> node = getNodeAtIndex(index);
        node.value = value;
    }

    @Override
    public void removeFirst() {
        if (size == 1) {
            first = last = null;
            size = 0;
        } else if (size != 0) {
            first = first.next;
            size--;
        }
    }

    @Override
    public void removeLast() {
        if (size() == 1) {
            first = last = null;
            size = 0;
        } else if (size() != 0) {
            Node<T> node = getNodeAtIndex(size - 2);
            last = node;
            node.next = null;
            size--;
        }
    }

    @Override
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<T> before = getNodeAtIndex(index - 1);
            before.next = before.next.next;
        }
    }

    @Override
    public void removeFirst(T value) {
        Node<T> node = first;
        while (node != null && !node.next.value.equals(value)) {
            node = node.next;
        }

        if (node != null) {
            node.next = node.next.next;
            size--;
        }
    }

    @Override
    public void removeLast(T value) {
        Node<T> node = first;
        Node<T> beforeRemove = null;
        while (node != null) {
            if (node.next.value.equals(value)) {
                beforeRemove = node;
            }
            node = node.next;
        }

        if (beforeRemove != null) {
            beforeRemove.next = beforeRemove.next.next;
            size--;
        }
    }

    @Override
    public void removeAll(T value) {
        Node<T> node = first;
        while (node != null) {
            if (node.next.value.equals(value)) {
                node.next = node.next.next;
                size--;
            }
            node = node.next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = last = null;
    }

    @Override
    public T popFirst() {
        T value = null;
        if (first != null) {
            value = first.value;
            removeFirst();
        }
        return value;
    }

    @Override
    public T popLast() {
        T value = null;
        if (last != null) {
            value = last.value;
            removeLast();
        }
        return value;
    }

    @Override
    public T pop(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        T value = null;
        if (index == 0) {
            value = popFirst();
        } else if (index == size - 1) {
            value = popLast();
        } else {
            Node<T> before = getNodeAtIndex(index - 1);
            value = before.next.value;
            before.next = before.next.next;
        }

        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleLinkedListIterator<>(first);
    }

    @Override
    public void forEach(Consumer<? super T> consumer) {
        Node<T> runner = first;
        while (runner != null) {
            consumer.accept(runner.value);
            runner = runner.next;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        SimpleLinkedList<T> other = (SimpleLinkedList<T>) o;

        if (size != other.size) {
            return false;
        }

        Node<T> runner = first;
        Node<T> otherRunner = other.first;
        while (runner != null && otherRunner != null) {
            if (!runner.value.equals(otherRunner.value)) {
                return false;
            }
            runner = runner.next;
            otherRunner = otherRunner.next;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = HASH_CODE_INITIAL_VALUE;

        for (T value: this) {
            result = HASH_CODE_MULTIPLIER * result + value.hashCode();
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<T> runner = first;

        while (runner != null) {
            stringBuilder.append(runner.value.toString());
            if (runner.next != null) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("]");
            }
        }

        return stringBuilder.toString();
    }
}

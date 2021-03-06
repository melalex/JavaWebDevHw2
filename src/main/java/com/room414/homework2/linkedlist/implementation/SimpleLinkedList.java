package com.room414.homework2.linkedlist.implementation;

import com.room414.homework2.linkedlist.interfaces.MyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class SimpleLinkedList<T> implements MyLinkedList<T> {
    private static final int HASH_CODE_INITIAL_VALUE = 17;
    private static final int HASH_CODE_MULTIPLIER = 37;

    protected static class Node<T> {
        protected T value;
        protected Node<T> next;

        protected Node(T value) {
            this.value = value;
        }
    }

    private static final class ForwardLinkedListIterator<T> implements Iterator<T> {
        Node<T> runner;

        private ForwardLinkedListIterator(Node<T> first) {
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
    }

    protected Node<T> first;
    protected Node<T> last;
    protected int size;

    public SimpleLinkedList() {

    }

    public SimpleLinkedList(Iterable<? extends T> other) {
        if (other != null) {
            for (T value: other) {
                addLast(value);
            }
        }
    }

    protected Node<T> createNode(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyLinkedList can't store null");
        }

        return new Node<>(value);
    }

    protected Node<T> getNodeAtIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        Node<T> node = first;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] asArray() {
        Object[] array = new Object[size];
        Node<T> runner = first;

        for (int i = 0; i < size; i++) {
            array[i] = runner.value;
            runner = runner.next;
        }

        return array;
    }

    @Override
    public void addLast(T value) {
        addLast(createNode(value));
    }

    private void addLast(Node<T> node) {
        if (size == 0) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    @Override
    public void addLast(Iterable<? extends T> other) {
        if (other == null) {
            throw new IllegalArgumentException("other can't be null");
        }

        SimpleLinkedList<T> appended = new SimpleLinkedList<>(other);

        if (appended.size != 0) {
            if (size == 0) {
                last = appended.last;
                first = appended.first;
            } else {
                last.next = appended.first;
                last = appended.last;
            }
        }

        size += appended.size;
    }

    @Override
    public void addFirst(T value) {
        Node<T> newNode = createNode(value);

        if (size() == 0) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }

        size++;
    }

    @Override
    public void addFirst(Iterable<? extends T> other) {
        if (other == null) {
            throw new IllegalArgumentException("other can't be null");
        }

        SimpleLinkedList<T> appended = new SimpleLinkedList<>(other);

        if (appended.size != 0) {
            if (size == 0) {
                last = appended.last;
                first = appended.first;
            } else {
                appended.last.next = this.first;
                first = appended.first;
            }
        }

        size += appended.size();
    }

    @Override
    public void insertAfter(T value, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        Node<T> nodeBefore = getNodeAtIndex(index);
        Node<T> newNode = createNode(value);

        if (nodeBefore.next != null) {
            newNode.next = nodeBefore.next;
        } else {
            last = newNode;
        }

        nodeBefore.next = newNode;

        size++;
    }

    @Override
    public void insertAfter(Iterable<? extends T> other, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        if (other == null) {
            throw new IllegalArgumentException("other can't be null");
        }

        SimpleLinkedList<T> appended = new SimpleLinkedList<>(other);

        if (appended.size != 0) {
            Node<T> nodeBefore = getNodeAtIndex(index);

            if (nodeBefore.next != null) {
                appended.last.next = nodeBefore.next;
            } else {
                last = appended.last;
            }

            nodeBefore.next = appended.first;
        }

        size += appended.size;
    }

    @Override
    public void insertBefore(T value, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        if (index != 0) {
            insertAfter(value, index - 1);
        } else if (size != 0) {
            addFirst(value);
        }
    }

    @Override
    public void insertBefore(Iterable<? extends T> other, int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        if (other == null) {
            throw new IllegalArgumentException("other can't be null");
        }

        if (index == 0) {
            addFirst(other);
        } else {
            insertAfter(other, index - 1);
        }
    }

    @Override
    public T getFirst() {
        T result = null;

        if (first != null) {
            result = first.value;
        }

        return result;
    }

    @Override
    public T getLast() {
        T result = null;

        if (last != null) {
            result = last.value;
        }

        return result;
    }

    @Override
    public T get(int index) {
        return getNodeAtIndex(index).value;
    }

    @Override
    public void setFirst(T value) {
        if (first == null) {
            first = last = createNode(value);
            size++;
        } else {
            first.value = value;
        }
    }

    @Override
    public void setLast(T value) {
        if (last == null) {
            first = last = createNode(value);
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
            size--;
        }
    }

    @Override
    public void removeFirst(T value) {
        Node<T> node = first;

        if (node != null && node.value.equals(value)) {
            removeFirst();
            return;
        }

        while (node != null && !node.next.value.equals(value)) {
            node = node.next;
        }

        if (node == last) {
            removeLast();
        } else if (node != null) {
            node.next = node.next.next;
            size--;
        }
    }

    @Override
    public void removeLast(T value) {
        Node<T> node = first;
        Node<T> beforeRemove = null;

        if (last != null && last.value.equals(value)) {
            removeLast();
            return;
        }

        while (node != null) {
            if (node.next != null && node.next.value.equals(value)) {
                beforeRemove = node;
            }
            node = node.next;
        }

        if (beforeRemove != null) {
            beforeRemove.next = beforeRemove.next.next;
            size--;
        } else if (first != null && first.value.equals(value)) {
            removeFirst();
        }
    }

    @Override
    public void removeAll(T value) {
        Node<T> node = first;
        Node<T> previousNode = null;

        while (node != null) {
            if (node.value.equals(value)) {
                if (node == first) {
                    removeFirst();
                } else if (node == last) {
                    removeLast();
                } else if (previousNode != null) {
                    previousNode.next = node.next;
                    size--;
                }
            }
            previousNode = node;
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

        T value;
        if (index == 0) {
            value = popFirst();
        } else if (index == size - 1) {
            value = popLast();
        } else {
            value = getNodeAtIndex(index).value;
            remove(index);
        }

        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new ForwardLinkedListIterator<>(first);
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
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> runner = first;

        stringBuilder.append("[");
        while (runner != null) {
            stringBuilder.append(runner.value.toString());
            if (runner.next != null) {
                stringBuilder.append(", ");
            }
            runner = runner.next;
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}

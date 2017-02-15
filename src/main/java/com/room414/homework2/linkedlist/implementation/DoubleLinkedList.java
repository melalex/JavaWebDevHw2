package com.room414.homework2.linkedlist.implementation;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Feb 2017
 */
public class DoubleLinkedList<T> extends SimpleLinkedList<T> {
    private static class DoubleLinkedNode<T> extends Node<T> {
        private DoubleLinkedNode<T> previous;

        private DoubleLinkedNode<T> getNext() {
            return (DoubleLinkedNode<T>) super.next;
        }

        private void setNext(DoubleLinkedNode<T> next) {
            super.next = next;
        }

        private DoubleLinkedNode<T> getPrevious() {
            return previous;
        }

        private void setPrevious(DoubleLinkedNode<T> previous) {
            this.previous = previous;
        }

        private DoubleLinkedNode(T value) {
            super(value);
        }
    }

    private static final class ReverseLinkedListIterator<T> implements Iterator<T> {
        DoubleLinkedNode<T> runner;

        private ReverseLinkedListIterator(DoubleLinkedNode<T> last) {
            runner = last;
        }

        @Override
        public boolean hasNext() {
            return runner.getPrevious() != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T current = runner.value;
                runner = runner.getPrevious();
                return current;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public DoubleLinkedList(Iterable<? extends T> other) {
        super(other);
    }

    public DoubleLinkedList() {
        super();
    }

    private void setFirstNode(DoubleLinkedNode<T> first) {
        super.first = first;
    }

    private void setLastNode(DoubleLinkedNode<T> last) {
        super.last = last;
    }

    private DoubleLinkedNode<T> getFirstNode() {
        return ((DoubleLinkedNode<T>) first);
    }

    private DoubleLinkedNode<T> getLastNode() {
        return ((DoubleLinkedNode<T>) last);
    }

    @Override
    protected DoubleLinkedNode<T> createNode(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyLinkedList can't store null");
        }
        return new DoubleLinkedNode<>(value);
    }

    @Override
    protected DoubleLinkedNode<T> getNodeAtIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(String.format(
                    "index should be in range [0;%s). Got %s.", size, index
            ));
        }

        if (index < size() - 1 - index) {
            return ((DoubleLinkedNode<T>) super.getNodeAtIndex(index));
        } else {
            DoubleLinkedNode<T> runner = getFirstNode();

            for (int i = size - 1; i >= index; i--) {
                runner = runner.getPrevious();
            }

            return runner;
        }
    }

    @Override
    public void addLast(T value) {
        DoubleLinkedNode<T> node = createNode(value);
        DoubleLinkedNode<T> lastNode = getLastNode();

        if (size == 0) {
            setFirstNode(node);
            setLastNode(node);
        } else {
            lastNode.setNext(node);
            node.setPrevious(lastNode);
            setLastNode(node);
        }

        size++;
    }

    @Override
    public void addLast(Iterable<? extends T> other) {
        if (other == null) {
            throw new IllegalArgumentException("other can't be null");
        }

        DoubleLinkedList<T> appended = new DoubleLinkedList<>(other);

        if (appended.size != 0) {
            if (size == 0) {
                setLastNode(appended.getLastNode());
                setFirstNode(appended.getFirstNode());
            } else {
                DoubleLinkedNode<T> lastNode = getLastNode();
                DoubleLinkedNode<T> appendedFirstNode = appended.getFirstNode();

                lastNode.setNext(appendedFirstNode);
                appendedFirstNode.setPrevious(lastNode);
                setLastNode(appended.getLastNode());
            }
        }

        size += appended.size;
    }

    @Override
    public void addFirst(T value) {
        DoubleLinkedNode<T> newNode = createNode(value);
        DoubleLinkedNode<T> firstNode = getFirstNode();

        if (size == 0) {
            setFirstNode(newNode);
            setLastNode(newNode);
        } else {
            newNode.setNext(firstNode);
            newNode.setPrevious(firstNode);
            setFirstNode(newNode);
        }

        size++;
    }

    @Override
    public void addFirst(Iterable<? extends T> other) {
        if (other == null) {
            throw new IllegalArgumentException("other can't be null");
        }

        DoubleLinkedList<T> appended = new DoubleLinkedList<>(other);

        if (appended.size != 0) {
            if (size == 0) {
                setLastNode(appended.getLastNode());
                setFirstNode(appended.getFirstNode());
            } else {
                DoubleLinkedNode<T> firstNode = getFirstNode();
                DoubleLinkedNode<T> appendedLastNode = appended.getLastNode();

                appendedLastNode.setNext(firstNode);
                firstNode.setPrevious(appendedLastNode);
                setFirstNode(appended.getFirstNode());
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

        if (index == size() - 1) {
            addLast(value);
        } else {
            DoubleLinkedNode<T> nodeBefore = getNodeAtIndex(index);
            DoubleLinkedNode<T> newNode = createNode(value);
            DoubleLinkedNode<T> nodeAfter = nodeBefore.getNext();

            newNode.setNext(nodeAfter);
            nodeAfter.setPrevious(newNode);
            newNode.setPrevious(nodeBefore);
            nodeBefore.setNext(newNode);
        }



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

        DoubleLinkedList<T> appended = new DoubleLinkedList<>(other);

        if (appended.size != 0) {
            DoubleLinkedNode<T> nodeBefore = getNodeAtIndex(index);
            DoubleLinkedNode<T> nodeAfter = nodeBefore.getNext();
            DoubleLinkedNode<T> appendedFirst = appended.getFirstNode();
            DoubleLinkedNode<T> appendedLast = appended.getLastNode();

            if (nodeAfter != null) {
                appendedLast.setNext(nodeAfter);
                nodeAfter.setPrevious(appendedLast);
            } else {
                setLastNode(appendedLast);
            }

            nodeBefore.setNext(appendedFirst);
            appendedFirst.setPrevious(nodeBefore);
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

        if (index == 0) {
            addFirst(value);
        } else {
            insertAfter(value, index - 1);
        }
    }

    @Override
    public void insertBefore(Iterable<? extends T> other, int index) {
        if (index == 0) {
            addFirst(other);
        } else {
            insertAfter(other, index - 1);
        }
    }

    @Override
    public void removeFirst() {
        if (size() == 1) {
            setFirstNode(null);
            setLastNode(null);
            size = 0;
        } else if (size() != 0) {
            DoubleLinkedNode<T> nodeAfter = getFirstNode().getNext();
            setFirstNode(nodeAfter);
            nodeAfter.setPrevious(null);
            size--;
        }
    }

    @Override
    public void removeLast() {
        if (size() == 1) {
            setFirstNode(null);
            setLastNode(null);
            size = 0;
        } else if (size() != 0) {
            DoubleLinkedNode<T> nodeAfter = getLastNode().getPrevious();
            setLastNode(nodeAfter);
            nodeAfter.setNext(null);
            size--;
        }
    }

    private void remove(DoubleLinkedNode<T> node) {
        if (node == getFirst()) {
            removeFirst();
        } else if (node == getLastNode()) {
            removeLast();
        } else if (size() != 0) {
            DoubleLinkedNode<T> nodeBefore = node.getPrevious();
            DoubleLinkedNode<T> nodeAfter = node.getPrevious();

            nodeBefore.setNext(nodeAfter);
            nodeAfter.setPrevious(nodeBefore);

            size--;
        }
    }

    @Override
    public void remove(int index) {
        DoubleLinkedNode<T> node = getNodeAtIndex(index);
        remove(node);
    }

    @Override
    public void removeFirst(T value) {
        DoubleLinkedNode<T> node = getFirstNode();

        while (node != null) {
            if (node.value.equals(value)) {
                remove(node);
                break;
            }
            node = node.getNext();
        }
    }

    @Override
    public void removeLast(T value) {
        DoubleLinkedNode<T> node = getLastNode();

        while (node != null) {
            if (node.value.equals(value)) {
                remove(node);
                break;
            }
            node = node.getPrevious();
        }
    }

    @Override
    public void removeAll(T value) {
        DoubleLinkedNode<T> node = getFirstNode();

        while (node != null) {
            if (node.value.equals(value)) {
                remove(node);
            }
            node = node.getNext();
        }
    }

    @Override
    public T popFirst() {
        T value = getFirst();
        removeFirst();
        return value;
    }

    @Override
    public T popLast() {
        T value = getLast();
        removeLast();
        return value;
    }

    @Override
    public T pop(int index) {
        DoubleLinkedNode<T> node = getNodeAtIndex(index);
        remove(node);
        return node.value;
    }

    public ReverseLinkedListIterator<T> reverseIterator() {
        return new ReverseLinkedListIterator<>(getLastNode());
    }
}

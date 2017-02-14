package com.room414.homework2.linkedlist.interfaces;

import com.room414.homework2.linkedlist.factories.LinkedListFactory;
import com.room414.homework2.linkedlist.factories.SimpleLinkedListFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
public class MyLinkedListTest {
    protected LinkedListFactory<Integer> testFactory = new SimpleLinkedListFactory<>();

    private MyLinkedList<Integer> listFrom1to3() {
        MyLinkedList<Integer> list = testFactory.create();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        return list;
    }

    private MyLinkedList<Integer> listFrom2to4() {
        MyLinkedList<Integer> list = testFactory.create();

        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        return list;
    }

    private MyLinkedList<Integer> listFrom1to4() {
        MyLinkedList<Integer> list = listFrom1to3();

        list.addLast(4);

        return list;
    }

    private MyLinkedList<Integer> listFrom5to8() {
        MyLinkedList<Integer> list = testFactory.create();

        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);

        return list;
    }

    private MyLinkedList<Integer> list124() {
        MyLinkedList<Integer> list = testFactory.create();

        list.addLast(1);
        list.addLast(2);
        list.addLast(4);

        return list;
    }

    private MyLinkedList<Integer> list1278() {
        MyLinkedList<Integer> list = testFactory.create();

        list.addLast(1);
        list.addLast(2);
        list.addLast(7);
        list.addLast(8);

        return list;
    }

    private MyLinkedList<Integer> listEmpty() {
        return testFactory.create();
    }

    private List<Integer> iterableFrom1to4() {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        return list;
    }

    private List<Integer> iterableFrom5to8() {
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        return list;
    }

    private List<Integer> iterableFrom3to6() {
        List<Integer> list = new LinkedList<>();

        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        return list;
    }

    private List<Integer> iterableEmpty() {
        return new LinkedList<>();
    }

    private List<Integer> iterableNull() {
        return null;
    }

    private Integer[] arrayFrom1To4() {
        return new Integer[] { 1, 2, 3, 4 };
    }

    private Integer[] arrayFrom2To4() {
        return new Integer[] { 2, 3, 4 };
    }

    private Integer[] arrayFrom1To3() {
        return new Integer[] { 1, 2, 3 };
    }

    private Integer[] array124() {
        return new Integer[] { 1, 2, 4 };
    }

    private Integer[] arrayFrom1To8() {
        return new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 };
    }

    @Test
    void asArray() {
        MyLinkedList<Integer> list = listFrom1to4();

        Object[] array = list.asArray();
        Integer[] result = arrayFrom1To4();

        assert Arrays.equals(array, result);
    }

    @Test
    void addLast() {
        MyLinkedList<Integer> list = listEmpty();
        list.addLast(1);

        assert list.getFirst() == 1;
        assert list.getLast() == 1;
        assert list.size() == 1;

        list.addLast(2);

        assert list.getFirst() == 1;
        assert list.getLast() == 2;
        assert list.size() == 2;
    }

    @Test
    void addLastIterable() {
        List<Integer> iterable = iterableFrom5to8();
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom1To8();

        list.addLast(iterable);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void addLastIterableToEmpty() {
        List<Integer> iterable = iterableFrom1to4();
        MyLinkedList<Integer> list = listEmpty();

        list.addLast(iterable);

        assert Arrays.equals(iterable.toArray(), list.asArray());
        assert iterable.size() == list.size();
    }

    @Test
    void addLastIterableNull() {
        List<Integer> iterable = iterableNull();
        MyLinkedList<Integer> list = listFrom1to4();

        assertThrows(IllegalArgumentException.class, () -> list.addLast(iterable));
    }

    @Test
    void addLastIterableEmpty() {
        List<Integer> iterable = iterableEmpty();
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom1To4();

        list.addLast(iterable);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void addFirst() {
        MyLinkedList<Integer> list = listEmpty();
        list.addFirst(1);

        assert list.getFirst() == 1;
        assert list.getLast() == 1;
        assert list.size() == 1;

        list.addFirst(2);

        assert list.getFirst() == 2;
        assert list.getLast() == 1;
        assert list.size() == 2;
    }

    @Test
    void addFirstIterableToEmpty() {
        List<Integer> iterable = iterableFrom1to4();
        MyLinkedList<Integer> list = testFactory.create();

        list.addFirst(iterable);

        assert Arrays.equals(iterable.toArray(), list.asArray());
        assert iterable.size() == list.size();
    }

    @Test
    void addFirstIterable() {
        List<Integer> iterable = iterableFrom1to4();
        MyLinkedList<Integer> list = listFrom5to8();
        Integer[] result = arrayFrom1To8();

        list.addFirst(iterable);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void addFirstIterableNull() {
        List<Integer> iterable = iterableNull();
        MyLinkedList<Integer> list = listFrom1to4();

        assertThrows(IllegalArgumentException.class, () -> list.addFirst(iterable));
    }

    @Test
    void addFirstIterableEmpty() {
        List<Integer> iterable = iterableEmpty();
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom1To4();

        list.addFirst(iterable);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void insertAfter() {
        MyLinkedList<Integer> list = list124();
        list.insertAfter(3, 1);

        Integer[] result = arrayFrom1To4();

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void insertAfterException() {
        MyLinkedList<Integer> list = listFrom1to4();

        assertThrows(IndexOutOfBoundsException.class, () -> list.insertAfter(5, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insertAfter(5, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insertAfter(5, list.size()));

        MyLinkedList<Integer> emptyList = listEmpty();

        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.insertAfter(5, 0));

    }

    @Test
    void insertAfterLast() {
        MyLinkedList<Integer> list = listFrom1to3();
        Integer[] result = arrayFrom1To4();

        list.insertAfter(4, list.size() - 1);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void insertAfterEmptyIterable() {
        List<Integer> iterable = iterableFrom1to4();
        MyLinkedList<Integer> list = listEmpty();

        assertThrows(IndexOutOfBoundsException.class, () -> list.insertAfter(iterable, 0));
    }

    @Test
    void insertAfterLastIterable() {
        List<Integer> iterable = iterableFrom5to8();
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom1To8();

        list.insertAfter(iterable, list.size() - 1);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void insertAfterIterable() {
        List<Integer> iterable = iterableFrom3to6();
        MyLinkedList<Integer> list = list1278();
        Integer[] result = arrayFrom1To8();

        list.insertAfter(iterable, 1);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void insertAfterIterableNull() {
        List<Integer> iterable = iterableNull();
        MyLinkedList<Integer> list = listFrom1to4();

        assertThrows(IllegalArgumentException.class, () -> list.insertAfter(iterable, 2));
    }

    @Test
    void insertAfterIterableEmpty() {
        List<Integer> iterable = iterableEmpty();
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom1To4();

        list.insertAfter(iterable, 2);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void insertBefore() {
        MyLinkedList<Integer> list = list124();
        Integer[] result = arrayFrom1To4();

        list.insertBefore(3, 2);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void insertBeforeException() {
        MyLinkedList<Integer> list = listFrom1to4();

        assertThrows(IndexOutOfBoundsException.class, () -> list.insertBefore(5, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insertBefore(5, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insertBefore(5, list.size()));

        MyLinkedList<Integer> emptyList = listEmpty();

        assertThrows(IndexOutOfBoundsException.class, () -> emptyList.insertBefore(5, 0));
    }

    @Test
    void insertBeforeFirst() {
        MyLinkedList<Integer> list = listFrom2to4();
        Integer[] result = arrayFrom1To4();

        list.insertBefore(1, 0);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void insertBeforeEmptyIterable() {
        List<Integer> iterable = iterableFrom1to4();
        MyLinkedList<Integer> list = listEmpty();

        assertThrows(IndexOutOfBoundsException.class, () -> list.insertBefore(iterable, 0));
    }

    @Test
    void insertBeforeFirstIterable() {
        List<Integer> iterable = iterableFrom1to4();
        MyLinkedList<Integer> list = listFrom5to8();
        Integer[] result = arrayFrom1To8();

        list.insertBefore(iterable, 0);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void insertBeforeIterable() {
        List<Integer> iterable = iterableFrom3to6();
        MyLinkedList<Integer> list = list1278();
        Integer[] result = arrayFrom1To8();

        list.insertBefore(iterable, 2);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void insertBeforeIterableNull() {
        List<Integer> iterable = iterableNull();
        MyLinkedList<Integer> list = listFrom1to4();

        assertThrows(IllegalArgumentException.class, () -> list.insertBefore(iterable, 2));
    }

    @Test
    void insertBeforeIterableEmpty() {
        List<Integer> iterable = iterableEmpty();
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom1To4();

        list.insertBefore(iterable, 2);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void getFirst() {
        MyLinkedList<Integer> list = listFrom1to4();
        assert list.getFirst() == 1;

        list = listEmpty();
        assert list.getFirst() == null;
    }

    @Test
    void getLast() {
        MyLinkedList<Integer> list = listFrom1to4();
        assert list.getLast() == 4;

        list = listEmpty();
        assert list.getLast() == null;
    }

    @Test
    void get() {
        MyLinkedList<Integer> list = listFrom1to4();

        assert list.get(0) == 1;
        assert list.get(1) == 2;
        assert list.get(2) == 3;
        assert list.get(3) == 4;
    }

    @Test
    void getException() {
        MyLinkedList<Integer> list = listFrom1to4();

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    void setFirst() {
        MyLinkedList<Integer> list = listFrom1to4();

        list.setFirst(Integer.MAX_VALUE);

        assert list.getFirst() == Integer.MAX_VALUE;
    }

    @Test
    void setLast() {
        MyLinkedList<Integer> list = listFrom1to4();

        list.setLast(Integer.MAX_VALUE);

        assert list.getLast() == Integer.MAX_VALUE;
    }

    @Test
    void set() {
        MyLinkedList<Integer> list = listFrom1to4();

        list.set(Integer.MAX_VALUE, 0);
        list.set(Integer.MAX_VALUE, 1);
        list.set(Integer.MAX_VALUE, 2);
        list.set(Integer.MAX_VALUE, 3);

        assert list.get(0) == Integer.MAX_VALUE;
        assert list.get(1) == Integer.MAX_VALUE;
        assert list.get(2) == Integer.MAX_VALUE;
        assert list.get(3) == Integer.MAX_VALUE;
    }

    @Test
    void setException() {
        MyLinkedList<Integer> list = listFrom1to4();

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, -1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 5));
    }

    @Test
    void removeFirst() {
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom2To4();

        list.removeFirst();

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void removeFirstOneElement() {
        MyLinkedList<Integer> list = listEmpty();
        list.addFirst(1);
        list.removeFirst();

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void removeFirstEmpty() {
        MyLinkedList<Integer> list = listEmpty();
        list.removeFirst();

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void removeLast() {
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom1To3();

        list.removeLast();

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void removeLastOneElement() {
        MyLinkedList<Integer> list = listEmpty();
        list.addFirst(1);
        list.removeLast();

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void removeLastEmpty() {
        MyLinkedList<Integer> list = listEmpty();
        list.removeLast();

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void remove() {
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = array124();

        list.remove(2);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void removeException() {
        MyLinkedList<Integer> list = listFrom1to4();

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    void removeOneElement() {
        MyLinkedList<Integer> list = listEmpty();
        list.addFirst(1);
        list.remove(0);

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void removeFirstOccurrence() {
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom1To4();

        list.addFirst(4);

        list.removeFirst(4);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void removeFirstOccurrenceOneElement() {
        MyLinkedList<Integer> list = listEmpty();
        list.addFirst(4);
        list.removeFirst(4);

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void removeFirstOccurrenceEmpty() {
        MyLinkedList<Integer> list = listEmpty();

        list.removeFirst(4);

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void removeLastOccurrence() {
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom1To4();

        list.addLast(1);
        list.removeLast(1);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void removeLastOccurrenceOneElement() {
        MyLinkedList<Integer> list = listEmpty();
        list.addFirst(4);
        list.removeLast(4);

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void removeLastOccurrenceEmpty() {
        MyLinkedList<Integer> list = listEmpty();

        list.removeLast(4);

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void removeAllOccurrence() {
        MyLinkedList<Integer> list = listFrom1to4();
        list.addFirst(4);
        Integer[] result = arrayFrom1To3();

        list.removeAll(4);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
    }

    @Test
    void removeAllOccurrenceOneElement() {
        MyLinkedList<Integer> list = listEmpty();
        list.addFirst(4);

        list.removeAll(4);

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void removeAllOccurrenceEmpty() {
        MyLinkedList<Integer> list = listEmpty();

        list.removeAll(4);

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void clear() {
        MyLinkedList<Integer> list = listFrom1to4();

        list.clear();

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void clearEmpty() {
        MyLinkedList<Integer> list = listEmpty();

        list.clear();

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
    }

    @Test
    void popFirst() {
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom2To4();

        int first = list.getFirst();
        int firstResult = list.popFirst();

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
        assert first == firstResult;
    }

    @Test
    void popFirstOneElement() {
        MyLinkedList<Integer> list = listEmpty();
        list.addFirst(1);

        int first = list.getFirst();
        int firstResult = list.popFirst();

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
        assert first == firstResult;
    }

    @Test
    void popFirstEmpty() {
        MyLinkedList<Integer> list = listEmpty();

        Integer first = list.popFirst();

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
        assert first == null;
    }

    @Test
    void popLast() {
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = arrayFrom1To3();

        int last = list.getLast();
        int lastResult = list.popLast();

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
        assert last == lastResult;
    }

    @Test
    void popLastOneElement() {
        MyLinkedList<Integer> list = listEmpty();
        list.addFirst(1);

        int last = list.getLast();
        int lastResult = list.popLast();

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
        assert last == lastResult;
    }

    @Test
    void popLastEmpty() {
        MyLinkedList<Integer> list = listEmpty();

        Integer last = list.popLast();

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
        assert last == null;
    }

    @Test
    void pop() {
        MyLinkedList<Integer> list = listFrom1to4();
        Integer[] result = array124();

        int element = list.get(2);
        int resultElement = list.pop(2);

        assert Arrays.equals(result, list.asArray());
        assert result.length == list.size();
        assert element == resultElement;
    }

    @Test
    void popException() {
        MyLinkedList<Integer> list = listFrom1to4();

        assertThrows(IndexOutOfBoundsException.class, () -> list.pop(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.pop(list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.pop(5));
    }

    @Test
    void popOneElement() {
        MyLinkedList<Integer> list = listEmpty();
        list.addFirst(1);

        int element = list.get(0);
        int resultElement = list.pop(0);

        assert list.getFirst() == null;
        assert list.getLast() == null;
        assert list.size() == 0;
        assert element == resultElement;
    }

    @Test
    void iterator() {
        MyLinkedList<Integer> list = listFrom1to4();
        Object[] array = list.asArray();
        int i = 0;

        for (Integer integer : list) {
            assert integer.intValue() == ((Integer) array[i]);
            i++;
        }

        assert i == list.size() - 1;
    }

    @Test
    void equalsTest() {
        MyLinkedList<Integer> list1 = listFrom1to4();
        MyLinkedList<Integer> list2 = listFrom1to4();
        MyLinkedList<Integer> list3 = listFrom1to3();
        MyLinkedList<Integer> list4 = listFrom5to8();

        MyLinkedList<Integer> listNull = null;
        List<Integer> iterable = iterableFrom1to4();

        assert list1.equals(list2);
        assert !list1.equals(list3);
        assert !list1.equals(listNull);
        assert !list1.equals(iterable);
        assert !list1.equals(list4);
        assert !list3.equals(list1);

        assert list1.hashCode() == list2.hashCode();
    }
}
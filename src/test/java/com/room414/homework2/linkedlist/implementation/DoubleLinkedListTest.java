package com.room414.homework2.linkedlist.implementation;

import com.room414.homework2.linkedlist.interfaces.MyLinkedList;
import com.room414.homework2.linkedlist.interfaces.MyLinkedListTest;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 14 Feb 2017
 */
class DoubleLinkedListTest extends MyLinkedListTest {

    @Override
    protected MyLinkedList<Integer> createList() {
        return new DoubleLinkedList<>();
    }

    @Override
    protected boolean isSolid(MyLinkedList<Integer> list, Object[] array) {
        int i = 0;

        for (Integer integer : list) {
            if (!integer.equals(array[i])) {
                return false;
            }
            i++;
        }

        Iterator<Integer> iterator = ((DoubleLinkedList) list).reverseIterator();

        while (iterator.hasNext()) {
            if (!iterator.next().equals(array[i])) {
                return false;
            }
            i--;
        }

        return true;
    }
}
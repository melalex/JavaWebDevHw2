package com.room414.homework2.linkedlist.implementation;

import com.room414.homework2.linkedlist.interfaces.MyLinkedList;
import com.room414.homework2.linkedlist.interfaces.MyLinkedListTest;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
class SimpleLinkedListTest extends MyLinkedListTest {

    @Override
    protected MyLinkedList<Integer> createList() {
        return new SimpleLinkedList<>();
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

        return true;
    }
}
package com.room414.homework2.linkedlist.implementation;

import com.room414.homework2.linkedlist.interfaces.MyLinkedList;
import com.room414.homework2.linkedlist.interfaces.MyLinkedListTest;

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
}
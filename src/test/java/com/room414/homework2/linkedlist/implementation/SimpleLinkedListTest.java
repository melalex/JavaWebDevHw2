package com.room414.homework2.linkedlist.implementation;

import com.room414.homework2.linkedlist.factories.SimpleLinkedListFactory;
import com.room414.homework2.linkedlist.interfaces.MyLinkedListTest;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 13 Feb 2017
 */
class SimpleLinkedListTest extends MyLinkedListTest {
    @BeforeEach
    void setUp() {
        testFactory = new SimpleLinkedListFactory<>();
    }
}
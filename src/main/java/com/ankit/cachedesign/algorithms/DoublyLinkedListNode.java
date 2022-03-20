package com.ankit.cachedesign.algorithms;

import lombok.Getter;

@Getter
public class DoublyLinkedListNode<E> {

  DoublyLinkedListNode<E>  next;
  DoublyLinkedListNode<E> prev;
  E element;

  public DoublyLinkedListNode(E element) {
    this.element = element;
    next = null;
    prev = null;
  }
}

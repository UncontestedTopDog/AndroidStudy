package com.edu.lib;

import java.util.LinkedList;

public class ListNode<T> {
    public Node<T> first;
    public Node<T> last;
    public int size;

    public ListNode() {
        size = 0;
    }

    public static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }

        public Node(T val) {
            this.val = val;
        }
    }

    public void addNode(T val) {
        Node tempLast = last;
        Node tempNode = new Node<>(val,null);
        last = tempLast;
        if (tempLast == null) {
            first = tempLast;
        } else {
            tempLast.next = last;
        }
        size++;
    }

    public void addNode(T val, int index) {
        if (index > size) {
            return;
        }
        Node temp = first;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node temp2 = temp.next;
        temp.next = new Node(val,temp2);
        size++;
    }
}

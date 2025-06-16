package com.hepengke.www.queue;

import com.hepengke.www.BiListNode;

public class LinkedListDeque {
    private BiListNode head, rear;
    private int size;

    public LinkedListDeque() {
        head = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offerFirst(int val) {
        BiListNode node = new BiListNode(val);
        //首次添加结点
        if (isEmpty()) {
            head = node;
            rear = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node.next;
        }
        size++;
    }

    public void offerLast(int val) {
        BiListNode node = new BiListNode(val);
        //首次添加结点
        if (isEmpty()) {
            head = node;
            rear = node;
        } else {
            node.prev = rear;
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public int peekFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        return head.val;
    }

    public int peekLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        return rear.val;
    }

    public int pollFirst() {
        int num = peekFirst();
        BiListNode nextNode = head.next;
        if (nextNode == null) {
            head = null;
            rear = null;
        } else {
            nextNode.prev = null;
            head.next = null;
            head = nextNode;
        }
        size--;
        return num;
    }

    public int pollLast() {
        int num = peekLast();
        BiListNode preNode = head.prev;
        if (preNode == null) {
            head = null;
            rear = null;
        } else {
            preNode.next = null;
            rear.prev = null;
            rear = preNode;
        }
        size--;
        return num;
    }
}

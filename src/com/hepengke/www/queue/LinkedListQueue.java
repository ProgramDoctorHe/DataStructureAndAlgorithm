package com.hepengke.www.queue;

import com.hepengke.www.baseelement.ListNode;

public class LinkedListQueue {
    private ListNode head, rear;
    private int size;

    public LinkedListQueue() {
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

    public void offer(int val) {
        ListNode node = new ListNode(val);
        //队列为空时
        if ((head == null) && (rear == null)) {
            head = node;
            rear = node;
        } else {
            //队列非空时
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public int poll() {
        int num = peek();
        head = head.next;
        //如果列表空,也把rear置为null
        if (head == null) {
            rear = null;
        }
        size--;
        return num;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("列表为空");
        }
        return head.val;
    }
}

package com.hepengke.www.stack;

import com.hepengke.www.baseelement.ListNode;

public class ListStack {
    private ListNode stackPeek;
    private int size;

    public ListStack() {
        stackPeek = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = stackPeek;
        stackPeek = newNode;
        size++;
    }

    public int pop() {
        int num = peek();
        stackPeek = stackPeek.next;
        size--;
        return num;
    }

    public int peek(){
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("栈为空");
        }
        return stackPeek.val;
    }
}

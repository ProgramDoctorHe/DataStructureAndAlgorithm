package com.hepengke.www.stack;

import java.util.ArrayList;

public class ArrayStack {
    private ArrayList<Integer> stack;

    public ArrayStack() {
        stack = new ArrayList<>();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(int val) {
        stack.add(val);
    }

    public int pop() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("栈为空");
        }
        return stack.remove(size() - 1);
    }

    public int peek(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("栈为空");
        }
        return stack.get(size() - 1);
    }
}

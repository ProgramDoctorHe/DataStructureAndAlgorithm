package com.hepengke.www.queue;

public class ArrayDeque {
    private int[] array;
    private int head;
    private int size;

    public ArrayDeque(int capacity) {
        array = new int[capacity];
        head = 0;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offerFirst(int val) {
        if (size == array.length) {
            System.out.println("队列已满");
            return;
        }
        head = (head - 1 + array.length) % array.length;
        array[head] = val;
        size++;
    }

    public void offerLast(int val){
        if(size == array.length){
            System.out.println("队列已满");
            return;
        }
        int rear = (head + size) % array.length;
        array[rear] = val;
        size++;
    }

    public int peekFirst(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("队列为空");
        }
        return array[head];
    }

    public int peekLast(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("队列为空");
        }
        int rear = (head + size - 1) % array.length;
        return array[rear];
    }

    public int pollFirst(){
        int num = peekFirst();
        head = (head + 1) % array.length;
        size--;
        return num;
    }

    public int pollLast(){
        int num = peekLast();
        size--;
        return num;
    }
}

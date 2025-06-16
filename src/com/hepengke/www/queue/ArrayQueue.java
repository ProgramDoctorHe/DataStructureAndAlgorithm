package com.hepengke.www.queue;

public class ArrayQueue {
    private int[] array;
    private int front;
    private int size;

    public ArrayQueue(int num) {
        array = new int[num];
        front = 0;
        size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void offer(int val) {
        if (size == capacity()) {
            System.out.println("队列已满");
            return;
        }
        int rear = (front + size) % capacity();
        array[rear] = val;
        size++;
    }

    public int poll() {
        int num = peek();
        front = (front + 1) % capacity();
        size--;
        return num;
    }

    public int peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("队列为空");
        }
        return array[front];
    }
}

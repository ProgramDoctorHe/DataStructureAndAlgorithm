package com.hepengke.www.array;

import java.util.Arrays;

public class MyArrayList {
    private int[] array;
    private int size;
    private int capacity = 10;
    private int extendRatio = 2;

    public MyArrayList() {
        array = new int[capacity];
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void add(int value) {
        if (size == capacity) {
            extendCapacity();
        }
        array[size] = value;
        size++;
    }

    public void insert(int pos, int value) {
        if (pos < 0 || pos > size - 1) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        if (size == capacity) {
            extendCapacity();
        }
        for (int i = size - 1; i >= pos; i--) {
            array[i + 1] = array[i];
        }
        array[pos] = value;
        size++;
    }

    public int remove(int pos) {
        if (pos < 0 || pos > size - 1) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        int returnNum = array[pos];
        for (int i = pos; i < size - 1; i++) {
            array[pos] = array[pos + 1];
        }
        size--;
        return returnNum;
    }

    public int get(int pos) {
        if (pos < 0 || pos > size - 1) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        return array[pos];
    }

    public void set(int pos, int value) {
        if (pos < 0 || pos > size - 1) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        array[pos] = value;
    }

    public int[] toArray(){
        return Arrays.copyOf(array,size);
    }

    private void extendCapacity() {
        capacity = capacity * extendRatio;
        int[] newArray = new int[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}

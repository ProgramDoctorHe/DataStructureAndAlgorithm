package com.hepengke.www.binarytree;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> maxHeap;

    public MaxHeap(List<Integer> nums) {
        maxHeap = new ArrayList<>(nums);
        // 堆化除叶节点以外的其他所有节点
        for (int i = parent(size() - 1); i >= 0; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return maxHeap.size();
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int i, int j) {
        int temp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, temp);
    }

    public int peek() {
        return maxHeap.get(0);
    }

    public void offer(int val) {
        maxHeap.add(val);
        shiftUp(size() - 1);
    }

    private void shiftUp(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException("超出范围");
        }
        while (true) {
            int p = parent(index);
            if (p < 0 || (maxHeap.get(index) <= maxHeap.get(p))) {
                break;
            }
            swap(index, p);
            index = p;
        }
    }

    public int poll() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("堆为空");
        }
        swap(0, size() - 1);
        int val = maxHeap.remove(size() - 1);
        shiftDown(0);
        return val;
    }

    private void shiftDown(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException("超出范围");
        }
        while (true) {
            int max = index;
            int left = left(index);
            int right = right(index);
            if (left < size() && maxHeap.get(left) > maxHeap.get(max)) {
                max = left;
            }
            if (right < size() && maxHeap.get(right) > maxHeap.get(max)) {
                max = right;
            }
            if (max == index) {
                break;
            }
            swap(max, index);
            index = max;
        }
    }
}

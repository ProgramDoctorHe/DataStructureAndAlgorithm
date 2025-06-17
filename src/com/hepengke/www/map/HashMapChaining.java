package com.hepengke.www.map;

import com.hepengke.www.baseelement.Pair;

import java.util.ArrayList;
import java.util.List;

public class HashMapChaining {
    private List<List<Pair>> buckets;
    private int size;
    private int capacity;
    private double loadFactor;
    private int threshold;
    private int extendRatio;

    public HashMapChaining() {
        size = 0;
        capacity = 16;
        loadFactor = 0.75;
        threshold = (int) (capacity * loadFactor);
        extendRatio = 2;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hashFunc(int key) {
        return key % capacity;
    }

    private void extend() {
        int newCapacity = capacity * extendRatio;
        List<List<Pair>> newBuckets = new ArrayList<>(newCapacity);
        for (int i = 0; i < newCapacity; i++) {
            newBuckets.add(new ArrayList<>());
        }
        size = 0;
        for (List<Pair> list : buckets) {
            for (Pair pair : list) {
                int pos = hashFunc(pair.key);
                List<Pair> bucket = newBuckets.get(pos);
                bucket.add(pair);
                size++;
            }
        }
        capacity = newCapacity;
        threshold = (int) (capacity * loadFactor);
        buckets = newBuckets;
    }

    public void put(int key, String val) {
        if (size > threshold) {
            extend();
        }
        int pos = hashFunc(key);
        List<Pair> bucket = buckets.get(pos);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                //更新指定数据
                pair.val = val;
                return;
            }
        }
        //未查到指定数据
        bucket.add(new Pair(key, val));
        size++;
    }

    public void remove(int key) {
        int pos = hashFunc(key);
        List<Pair> bucket = buckets.get(pos);
        for (int i = 0; i < bucket.size(); i++) {
            Pair pair = bucket.get(i);
            if (pair.key == key) {
                bucket.remove(pair);
                size--;
                break;
            }
        }
    }

    public String get(int key) {
        int pos = hashFunc(key);
        List<Pair> bucket = buckets.get(pos);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                //查到指定数据
                return pair.val;
            }
        }
        //未查到自定数据
        return null;
    }
}

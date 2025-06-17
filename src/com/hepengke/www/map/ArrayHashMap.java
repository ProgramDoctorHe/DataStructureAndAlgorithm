package com.hepengke.www.map;

import com.hepengke.www.baseelement.Pair;

import java.util.*;

public class ArrayHashMap {
    private List<Pair> buckets;
    private int size;

    public ArrayHashMap() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            buckets.add(null);
        }
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hashFunc(int key) {
        return key % 100;
    }

    public void put(int key, String val) {
        Pair pair = new Pair(key, val);
        int pos = hashFunc(key);
        buckets.set(pos, pair);
        size++;
    }

    public void remove(int key) {
        int pos = hashFunc(key);
        buckets.set(pos, null);
        size--;
    }

    public String get(int key) {
        int pos = hashFunc(key);
        Pair pair = buckets.get(pos);
        if (pair == null) {
            return null;
        }
        return pair.val;
    }

    public Set<Pair> entrySet() {
        Set<Pair> entrySet = new HashSet<>();
        for (Pair pair : buckets) {
            if (pair != null) {
                entrySet.add(pair);
            }
        }
        return entrySet;
    }

    public Set<Integer> keySet() {
        Set<Integer> keySet = new HashSet<>();
        for (Pair pair : buckets) {
            if (pair != null) {
                keySet.add(pair.key);
            }
        }
        return keySet;
    }

    public List<String> values() {
        List<String> list = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null) {
                list.add(pair.val);
            }
        }
        return list;
    }
}

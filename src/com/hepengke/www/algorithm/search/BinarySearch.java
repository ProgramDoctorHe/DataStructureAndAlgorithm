package com.hepengke.www.algorithm.search;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] > target) {
                j = mid - 1;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        //没找到,返回-1
        return -1;
    }

    /* 二分查找插入点（无重复元素） */
    public static int binarySearchInsertionSimple(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] > target) {
                j = mid - 1;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return i;
    }

    /* 二分查找插入点（存在重复元素） */
    public static int binarySearchInsertion(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] > target) {
                j = mid - 1;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        //返回插入点
        return i;
    }

    /* 二分查找最左一个 target */
    public static int binarySearchLeftEdge(int[] arr, int target) {
        int i = binarySearchInsertion(arr, target);
        //没有找到,返回-1
        if (i < 0 || i > arr.length - 1 || arr[i] != target) {
            return -1;
        }
        return i;
    }

    /* 二分查找最右一个 target */
    public static int binarySearchRightEdge(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] > target) {
                j = mid - 1;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                i = mid + 1;
            }
        }
        //没有找到,返回-1
        if (i < 0 || i > arr.length - 1 || arr[i - 1] != target) {
            return -1;
        }
        return i - 1;
    }
}

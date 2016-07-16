package com.zhenghuiy.chapter_1;

/**
 * Created by yzh on 16/7/16.
 */
public class BinarySearch {
    /**
     * 循环实现二分查找
     * @param key 查找的数
     * @param array 有序int数组
     * @return key所在的位置
     */
    public static int bSearchByLoop(final int key, final int[] array) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < array[mid]) {
                hi = mid - 1;
            } else if (key > array[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * 使用递归实现二分查找
     * @param key 查找的数
     * @param array 有序int数组
     * @return key所在的位置
     */
    public static int bSearchByRecur(final int key, final int[] array) {
        return search(0, array.length - 1, key, array);
    }

    private static int search(int lo, int hi, final int key, final int[] array) {
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        if (key == array[mid]) {
            return mid;
        } else if (key > array[mid]) {
            return search(mid + 1, hi, key, array);
        } else {
            return search(lo, mid - 1, key, array);
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 3, 4, 7, 9, 10, 15};

        System.out.println(bSearchByLoop(4, array));
        System.out.println(bSearchByRecur(4, array));
    }

}

package com.kcaco.algorithms.sort;

import java.util.Arrays;

/**
 * Description: 插入排序
 *
 * @author kcaco
 * @since 2022-09-23 22:36
 */
public class InsertionSort {

    /**
     * 插入排序
     *
     * @param arr 数组
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        // 从第二个元素开始为它们找位置
        for (int i = 1; i < arr.length; i++) {
            // 当前元素
            int current = arr[i];
            int pre;

            // 从当前元素左边第一个元素开始，向左找位置
            for (pre = i - 1; pre >= 0 && arr[pre] > current; pre--) {
                arr[pre + 1] = arr[pre];
            }

            // 找到合适位置后，将当前元素插入
            arr[pre + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 6, 4, 9, 8, 5, 3, 1, 2, 0};
        insertionSort(array);
        // [0, 1, 1, 2, 2, 3, 4, 5, 5, 6, 8, 9]
        System.out.println(Arrays.toString(array));
    }


}

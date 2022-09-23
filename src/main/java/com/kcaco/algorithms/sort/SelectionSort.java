package com.kcaco.algorithms.sort;

import java.util.Arrays;

/**
 * Description: 选择排序
 * <p>
 * 设计思想：
 * 1、从数组中选择最小元素，将它与数组的第一个元素交换位置。
 * 2、再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
 * 3、不断进行这样的操作，直到将整个数组排序。
 *
 * @author kcaco
 * @since 2022-09-23 21:42
 */
public class SelectionSort {

    /**
     * 选择排序
     *
     * @param array 数组
     */
    public static void selectionSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            // 最小数索引
            int minIndex = i;

            // 找到最小的数
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    // 将最小数的索引保存
                    minIndex = j;
                }
            }

            // 如果最小数索引改变，则交换数据
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}

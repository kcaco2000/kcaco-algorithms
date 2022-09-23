package com.kcaco.algorithms.sort;

import java.util.Arrays;

/**
 * Description: 冒泡排序
 *
 * @author kcaco
 * @since 2022-09-23 22:02
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr 数组
     */
    public static void bubbleSort1(int[] arr) {
        // 设置每次冒泡的终止点、循环次数
        for (int i = arr.length - 1; i > 0; i--) {
            boolean change = false;

            // 从起点开始冒泡
            for (int j = 0; j < i; j++) {
                // 前一个比后一个大，交换位置
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    if (!change) {
                        change = true;
                    }
                }
            }

            // 如果本次无交换，则表示已有序，排序完成
            if (!change) {
                return;
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param array 数组
     */
    public static void bubbleSort2(int[] array) {
        // 外层循环，即循环的次数
        for (int i = 0; i < array.length - 1; i++) {
            // 通过符号位可以减少无谓的比较，如果已经有序了，就退出循环
            int flag = 0;

            // 内层循环，它决定每趟走一次   -1是防止溢出
            for (int j = 0; j < array.length - i - 1; j++) {
                //如果后一个大于前一个,则换位
                if (array[j + 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = 1;
                }
            }

            // 如果本次无交换，则表示已有序，排序完成
            if (flag == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 1, 6, 4, 9, 8, 5, 3, 1, 2, 0};
        bubbleSort1(array);
        System.out.println(Arrays.toString(array));
    }
}

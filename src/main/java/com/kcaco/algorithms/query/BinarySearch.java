package com.kcaco.algorithms.query;

/**
 * Description: 二分查找
 * <p>
 * 使用限制：
 * 1、顺序表
 * 2、有序数据
 * 3、插入、删除操作不频繁，一次排序多次查找的场景中
 *
 * @author kcaco
 * @since 2022-09-23 17:55
 */
public class BinarySearch {


    /**
     * 二分查找——没有重复数据
     *
     * @param arr    数组
     * @param target 目标元素
     * @return 下标
     */
    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // 确定查找的区间
        int left = 0;
        int right = arr.length - 1;

        // 开始查找【left，right】区间
        while (left <= right) {
            // 找到中间数的索引
            int mid = (left + right) / 2;

            // 判断 中间数 和 target 的大小
            if (arr[mid] == target) {
                // 若相等，则返回其索引
                return mid;
            } else if (arr[mid] > target) {
                // 中点>要查找的值，最大值下标=mid-1
                right = mid - 1;
            } else if (arr[mid] < target) {
                // 如果中点<要查找的值，最小值下标=mid+1
                left = mid + 1;
            }
        }

        // 如果未查找到，则返回-1
        return -1;
    }

    /**
     * 有重复数据的二分查找——左侧
     *
     * @param arr    数组
     * @param target 目标值
     * @return 索引下标
     */
    public static int binarySearchRepeatLeft(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length;               // 右侧未闭合

        while (left < right) {                // left==right时，退出循环
            int mid = (left + right) / 2;

            if (arr[mid] == target) {         // 找到时，right向右侧靠拢，记住此位置
                right = mid;
            } else if (arr[mid] < target) {    // 小于时，左侧闭合，向右靠拢
                left = mid + 1;
            } else if (arr[mid] > target) {    // 大于时，右侧不闭合，向左靠拢
                right = mid;
            }
        }

        // 如果target大于所有元素，返回-1
        if (left == arr.length) {
            return -1;
        }

        return arr[left] == target ? left : -1;
    }

    /**
     * 有重复数据的二分查找——右侧侧
     *
     * @param arr    数组
     * @param target 目标值
     * @return 索引下标
     */
    public static int binarySearchRepeatRight(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid;
            }
        }

        if (left == 0) {
            return -1;
        }

        return arr[left - 1] == target ? (left - 1) : -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 8, 13, 19, 20, 33, 38, 40, 48, 88};

    }

}

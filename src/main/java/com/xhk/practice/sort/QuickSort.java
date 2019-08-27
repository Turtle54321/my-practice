package com.xhk.practice.sort;

import java.util.Arrays;

/**
 * 快排(单次排序时，指定第一个为root节点，保证排完序后比root小的在其左边，大的在右边)
 * 然后用递归，单次排完序后，递归排序左边和右边的
 *
 * @author xuhaikun
 * @date 2019-06-30
 */
public class QuickSort {
    public static void main(String[] args) {

        Integer[] array = {12, 2, 235, 3, 43, 345, 3, 453, 2, 45, 3, 23633, 2342234, 234};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));


    }

    private static int onceSort(Integer[] array, int left, int right) {
        Integer root = array[left];
        while (left < right) {
            while (left < right && array[right] >= root) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= root) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = root;
        return left;
    }

    private static void quickSort(Integer[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = onceSort(array, left, right);
        quickSort(array, 0, p - 1);
        quickSort(array, p + 1, right);
    }
}

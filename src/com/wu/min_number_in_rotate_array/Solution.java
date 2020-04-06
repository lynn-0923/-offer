package com.wu.min_number_in_rotate_array;

import java.util.ArrayList;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 *
 * 分析：
 *     二分查找变种，没有具体的值用来比较。那么用中间值和高低位进行比较，看处于递增还是递减序列，进行操作缩小范围。
 *
 *     处于递增：low上移
 *
 *     处于递减：high下移（如果是high-1，则可能会错过最小值，因为找的就是最小值）
 *
 *     其余情况：low++缩小范围
 *
 * @author lynn
 * @date 2020/4/6 - 15:24
 */
public class Solution {
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low < high){
            if (array[low] < array[high]){
                return array[low];
            }
            mid = low + (high - low) / 2;
            if (array[mid] > array[low]){
                low = mid + 1;
            }else if(array[mid] < array[high]){
                  high = mid;
            }else {
                low++;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 1, 2};
        int i = minNumberInRotateArray(arr);
        System.out.println(i);
    }
}

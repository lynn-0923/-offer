package com.wu.more_than_half_num;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 *
 * @author lynn
 * @date 2020/3/31 - 10:34
 */
public class Solution {
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int len = array.length;
        int maxSize = len / 2;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.keySet().contains(array[i])){
                map.put(array[i],1);
            }else {
                map.put(array[i],map.get(array[i]) + 1);
            }
        }
        for (Integer key : map.keySet()){
            if (map.get(key) > maxSize){
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int i = MoreThanHalfNum_Solution(arr);
        System.out.println(i);
    }
}

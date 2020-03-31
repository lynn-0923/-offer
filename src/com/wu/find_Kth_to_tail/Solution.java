package com.wu.find_Kth_to_tail;

/**
 * @author lynn
 * @date 2020/3/21 - 14:42
 */
//输入一个链表，输出该链表中倒数第k个结点。
public class Solution {
    public ListNode findKthToTail(ListNode head, int k) {
        ListNode temp = head;
        int m = getC(temp);
        if (head == null || k == 0 || k > m) {
            return null;
        }
            for (int i = 0; i < m - k; i++) {
                head = head.next;
            }
        return head;
    }

    int count = 0;
    public int getC(ListNode node) {
        if (node == null) {
            return count;
        }

        while (true) {
            count++;
            if (node.next == null) {
                break;
            }
            node = node.next;
        }
        return count;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
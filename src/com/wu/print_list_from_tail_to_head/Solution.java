package com.wu.print_list_from_tail_to_head;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lynn
 * @date 2020/3/21 - 10:04
 */
// 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack();
        if (listNode == null) {
            return list;
        }
        while (true) {
            if (listNode != null) {
                stack.add(listNode.val);
            }
            if (listNode.next == null) {
                break;
            }
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
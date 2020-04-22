package com.wu.reverse_list;

/**
输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        //定义一个辅助的指针，帮助遍历原来的链表
        ListNode cur = head;
        //存放cur的下一个节点，方便后移
        ListNode next = null;
        ListNode newNode = new ListNode(0);
        while (cur != null){
            //临时存放
            next = cur.next;
            //将cur的下一个节点指向新链表的最前端
            cur.next = newNode.next;
            //将cur存放在新链表上
            newNode.next = cur;
            //指向下一个节点
            cur = next;
        }
        //反转链表
        head = newNode.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode listNode = reverseList(node1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

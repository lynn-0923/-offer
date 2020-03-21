package com.wu.stack_to_queue;

import org.junit.Test;

import java.util.Stack;

/**
 * @author lynn
 * @date 2020/3/21 - 9:27
 */
//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
public class queueDemo {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        push(node1.id);
        push(node2.id);
        push(node3.id);
        push(node4.id);
        push(node5.id);
        int pop = pop();
        System.out.println(pop);
        while (!stack2.empty()) {
            System.out.println(pop());
        }
    }
}

class Node {
    int id;

    public Node(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "node{" +
                "id=" + id +
                '}';
    }
}
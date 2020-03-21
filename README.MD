### 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
```java
public class TreePrintFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node =root;
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.left!= null) {
                queue.add(node.right);
            }
        }
        return list;
    }
}
```
### 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
```java
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
}
```
### 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
```java
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
```
###  输入一个链表，输出该链表中倒数第k个结点。
```java
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
```
### 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
##### 方法一
```java
public class Solution {
public static String replaceSpace(StringBuffer str) {
           return   str.toString().replace(" ","%20");
    }
}
```
##### 方法二
```java

public class Solution {
    public static   String replaceSpace(StringBuffer str) {
        if (str == null && str.length() == 0) {
            return null;
        }
        for (int i = 0; i <str.length();) {
            CharSequence charSequence =str.subSequence(i, i + 1);
            if (charSequence.equals(" ")){
                str.replace(i,i+1,"%20");
                i+=3;
            }else {
                i++;
            }
        }
        return  (str.toString());
    }
}
```
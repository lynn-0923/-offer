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
            if (node.right!= null) {
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
### 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
###### 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
```java
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
```
### 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

##### 方式一
```java
public class Solution {
    public static boolean find(int target, int[][] array) {

        int find = -1;
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            int[] arr = array[i];
            find = Arrays.binarySearch(arr, target);
            if (find >= 0) {
                if (array[i][find] == target) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

        boolean b = find(5, arr);
        System.out.println(b);
    }
}
```
##### 方式二
```java
public class Solution {
    public static boolean find(int target, int[][] array) {
        int m, n, x, y;
        m = array.length;//行数
        n = array[0].length;//列数
        x = m - 1;
        y = 0;//坐标定在左下角
        while (x >= 0 && y <= n - 1) {
            if (target < array[x][y]) {
                x--;//遇小上移
            } else if (target > array[x][y]) {
                y++;//遇大右移
            } else {
                return true;
            }
        }
        return false;
    }
}
```

### 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
  ##### 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
  
#### 分析：
    二分查找变种，没有具体的值用来比较。那么用中间值和高低位进行比较，看处于递增还是递减序列，进行操作缩小范围。
    处于递增：low上移
    处于递减：high下移（如果是high-1，则可能会错过最小值，因为找的就是最小值）
    其余情况：low++缩小范围
   
```java
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
```
### 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
```java
public class Solution {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        int rootVal = pre[0];
        TreeNode tree = new TreeNode(rootVal);

        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (rootVal == in[i]) {
                index = i;
                break;
            }
        }
        tree.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(in, 0, index));
        tree.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
        return tree;
    }


    public static void main(String[] args) {
        //测试
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        treeNode.preOrder();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this.val);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
```
### 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
```java
public class Solution {
    public int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        //方式一：非递归（推荐）
        int a = 1, b = 2, result = 0;
        for (int i = 2; i < target; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
        //方式二
//        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
```
### 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。 求该青蛙跳上一个n级的台阶总共有多少种跳法。
```java
public class Solution {
    public static int jumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        //方式一
//        return (int) Math.pow(2,target - 1);

        //方式二
        int b = 2 ,result = 0;
        for (int i = 2; i < target ; i++) {
            result = 2 * b;
            b = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = jumpFloorII(5);
        System.out.println(i);
    }
}
```
### 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
```java
public class Solution {
    public static int numberOf1(int n) {

        //方式一，利用api
//        String s = Integer.toBinaryString(n);
//        String[] split = s.split("");
//        int count = 0;
//        for (int i = 0; i < split.length; i++) {
//            if ("1".equals(split[i])){
//                count++;
//            }
//        }

//        方式二
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int i = numberOf1(-5);
        System.out.println(i);
    }
}
```
### 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
```java
public class Solution {
    public  double power(double base, int exponent) {
        if (base == 0.0) {
            return 0.0;
        } else if (exponent == 0) {
            return 1;
        }
        double value = 1.0;

        int a = exponent > 0 ? exponent : -exponent;

        for (int i = 0; i < a; i++) {
            value = value * base;
        }
        return exponent > 0 ? value : 1 / value;
    }
}
```
### 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
```java
public class Solution {
    public void reOrderArray(int[] array) {

        int[] newArr = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                newArr[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                newArr[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length ; i++) {
            array[i] = newArr[i];
        }
    }
}
```
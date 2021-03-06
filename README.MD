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
### 输入一个链表，反转链表后，输出新链表的表头。
```java
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
}
```
### 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
```java
public class Solution {
    public ListNode merge(ListNode list1, ListNode list2) {
        //新建一个头节点，用来存合并的链表。
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode root = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                head = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = list2;
                list2 = list2.next;
            }
        }
        //把未结束的链表连接到合并后的链表尾部
        if (list1 != null) {
            head.next = list1;
        }
        if (list2 != null) {
            head.next = list2;
        }
        return root.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
```
### 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
1.首先需要判断A,B的根节点是否一样。
2.如果不一样，判断A的左孩子和B的根节点是否一样，同理可判断A的右孩子和B的根节点是否一样。依次找下去
如果上述情况都不满足则说明不包含
    1.如果找到了A中有值和B中的根节点相同，则比较左右子树是否相同。
    2.如果B为空了，则说明包含
    3.如果A为空了，则说明不包含
 ```java
public class Solution {
    //遍历大树
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        //判断两个子树节点的值是否相等
        if (root1.val == root2.val){//相等
            if (judgeSub(root1,root2)) {
                return true;//接着判断
            }
        }
        //如果不等，则遍历大树的左右子树
        return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    private boolean judgeSub(TreeNode root, TreeNode sub) {
        //如果子结构为null则遍历完毕,包含
        if (sub == null){
            return true;
        }
        //如果父结构为null则遍历完毕,不包含
        if (root == null){
            return false;
        }
        //判断是否相等
        if (root.val == sub.val){
            //判断左右子树
            return judgeSub(root.left,sub.left) && judgeSub(root.right,sub.right);
        }
        return false;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
```
### 操作给定的二叉树，将其变换为源二叉树的镜像。
```java
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return;
        }
        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;
        if (root.left != null){
            Mirror(root.left);
        }
        if (root.right != null){
            Mirror(root.right);
        }
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
```
### 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
#### 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
```java
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        //最上一行
        int up = 0;
        //最右边
        int right = matrix[0].length - 1;
        //最下边
        int down = matrix.length - 1;
        //最左边
        int left = 0;

        while (true){
            //遍历最上一行
            for (int col = left; col <= right; col++) {
                list.add(matrix[up][col]);
            }
            up++;
            if (up > down){
                break;
            }
            //遍历最右一行
            for (int row = up; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            right--;
            if (left > right){
                break;
            }
            //遍历最下一行
            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }
            down--;
            if (up > down){
                break;
            }
            //遍历最左一行
            for (int row = down; row >= up; row--) {
                list.add(matrix[row][left]);
            }
            left++;
            if (left > right){
                break;
            }
        }
        return list;
    }
}
```
### 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
```java
public class Solution {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            if (minStack.peek() > node) {
                minStack.push(node);
            } else {
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
```
### 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
#### 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列， 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
```java
public class Solution {
    public static boolean isPopOrder(int[] pushA, int[] popA) {

        if (pushA.length == 0 || popA.length == 0 || popA.length != pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
```
### 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
```java
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0 || sequence == null) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {
        if (start >= end) {
            //判断结束
            return true;
        }
        //用于判断，因为后序遍历为左右根
        int val = sequence[end];
        int i;
        for (i = start; i < end; i++) {
            if (sequence[i] > val) {
                break;
            }
        }
        //判断右子树是否有小于val的值
        for (int j = i; j < end; j++) {
            if (sequence[j] < val) {
                return false;
            }
        }
        //递归判断
        if (start == i) {
            return verify(sequence, start, end - 1);
        }
        return verify(sequence, start, i - 1) && verify(sequence, i, end - 1);
    }
}
```
### 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
#### 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
```java
public class Solution {

    private ArrayList<ArrayList<Integer>> resultList = new ArrayList();
    private ArrayList<Integer> list = new ArrayList();
    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return resultList;
        }
        list.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(list));
        }
        if (target > root.val) {
            if (root.left != null) {
                FindPath(root.left, target - root.val);
                //如果遍历到最后还没有，则进行回溯，类似于深度优先遍历
                list.remove(list.size() - 1);
            }
            if (root.right != null) {
                FindPath(root.right, target - root.val);
                list.remove(list.size() - 1);
            }
        }
        return resultList;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
```
package com.wu.replace_space;

/**
 * @author lynn
 * @date 2020/3/21 - 18:17
 */
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。
//例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class Solution {
    //方法一
    public static String replaceSpace(StringBuffer str) {
           return   str.toString().replace(" ","%20");
    }
    //方法二
  /*  public static   String replaceSpace(StringBuffer str) {
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
    }*/
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        String str = "We Are Happy";
        buffer.append(str);
        String s = replaceSpace(buffer);
        System.out.println(s);
    }
}
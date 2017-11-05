package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * Created by MelloChan on 2017/11/4.
 */
public class No28 {
    public static void main(String[] args) {
        String str="abc";
        System.out.println(new Solution28().permutation(str));
    }
}

/**
 * 解决方案:回溯算法
 *                      A|B|C
 *         A|B|C        B|A|C         C|B|A
 *     A|B|C  A|B|C  B|A|C B|C|A   C|B|A C|A|B
 */
class Solution28 {
     public ArrayList<String> permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str != null && str.length() > 0) {
            permutation(arrayList, str.toCharArray(), 0);
            Collections.sort(arrayList);//字典排序
        }
        return arrayList;
    }

    public void permutation(ArrayList<String> arrayList, char[] str, int begin) {
        if (begin == str.length-1) {
            String val=String.valueOf(str);
            if (!arrayList.contains(val)) {
                arrayList.add(val);
            }
        } else {
            int length=str.length;
            for (int i = begin; i <length; i++) {
                swap(str,begin,i);
                permutation(arrayList,str,begin+1);
                swap(str,begin,i);
            }
        }
    }
    private void swap(char[] str,int begin,int i){
        char temp=str[begin];
        str[begin]=str[i];
        str[i]=temp;
    }
}

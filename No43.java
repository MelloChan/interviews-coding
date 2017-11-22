package 剑指offer;

import java.util.Arrays;

/**
 * 翻转单词序列
 * Created by MelloChan on 2017/11/21.
 */
public class No43 {
    public static void main(String[] args) {
        String str = "I am a student.";
        Solution43 solution43 = new Solution43();
        System.out.println(solution43.reverseSentence(str));
    }
}

/**
 * 解决方案: 先翻转整个单词句子序列,然后在逐一翻转单个单词
 */
class Solution43 {
    public String reverseSentence(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        int begin = 0, end = str.length() - 1, length = str.length();
        char[] chars = str.toCharArray();
        reverse(chars, begin, end); //对整个句子进行翻转
        end = 0;
        while (begin < length) {
            if (chars[begin] == ' ') {  //指向空格的情况下 向前移动
                ++begin;
                ++end;
            } else if (end == length || chars[end] == ' ') {
                reverse(chars, begin, --end); //对单个单词进行翻转
                begin = ++end;
            } else {  //end指针向前走 直至遇到空格
                ++end;
            }
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int begin, int end) {
        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            ++begin;
            --end;
        }
    }

}

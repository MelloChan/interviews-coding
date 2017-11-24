package 剑指offer;

/**
 * 左旋转字符串
 * Created by MelloChan on 2017/11/22.
 */
public class No44 {
    public static void main(String[] args) {
        Solution44 s = new Solution44();
        System.out.println(s.leftRotateString("abcdefg", 2));
    }
}

/**
 * 解决方案: 将字符串分割为两部分, 左旋部分与不变部分,依次旋转
 * 然后在统一旋转整个字符串
 */
class Solution44 {
    public String leftRotateString(String str, int n) {
        if (str == null || str.length() <= 1 || n <= 0 || n > str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        int length = str.length();
        int firstStart = 0, firstEnd = n - 1;
        int secondStart = n, secondEnd = length - 1;   //abcefg 2
        reverse(chars, firstStart, firstEnd); // 例如:  ab -> ba
        reverse(chars, secondStart, secondEnd); //  cefg -> gfec
        reverse(chars, firstStart, secondEnd); // -> bagfec -> cefgab
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
package 剑指offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * Created by MelloChan on 2017/10/20.
 */
public class No10 {
    public static void main(String[] args) {
        System.out.println(new Solution10().numberOf1(15));
    }
}

/**
 * 利用位移运算符以及&的特性
 * 1001 = 9 - 1 = 1000 & 1001 = 10000 - 1 = 1111 & 10000 = 0 结束 -> count=2
 */
class Solution10 {
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}

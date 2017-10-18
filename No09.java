package 剑指offer;

/**
 * 输入一个整数n，输出斐波那契数列的第n项。
 * 1 1 2 3 5 8 13 21
 * Created by MelloChan on 2017/10/17.
 */
public class No09 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution09().fibonacciWithRecursion(39));
        long end1 = System.currentTimeMillis();
        System.out.println(new Solution09().fibonacci(39));
        long end2 = System.currentTimeMillis();
        System.out.println("fibonacciWithRecursion:" + (end1 - start));
        System.out.println("fibonacci:" + (end2 - end1));

    }
}

/**
 * 解决方案: 递归 ||  循环
 */
class Solution09 {
    /**
     * 低效
     * @param n
     * @return
     */
    public int fibonacciWithRecursion(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciWithRecursion(n - 1) + fibonacciWithRecursion(n - 2);
    }

    /**
     * 实用
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 1, second = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int temp = first + second;
            result = temp;
            first = second;
            second = result;
        }
        return result;
    }
}

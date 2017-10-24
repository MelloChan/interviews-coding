package 剑指offer;

/**
 * 输入数字n,按顺序打印出从1到最大的n位十进制数
 * 例子:输入3,输出 1 2 3 ......999
 * Created by MelloChan on 2017/10/22.
 */
public class No12 {
    public static void main(String[] args) {
        new Solution12().printNum(3);
    }
}

/**
 * 解决方案:利用数组+递归
 */
class Solution12 {
    public void printNum(int n) {
        if (n <= 0) {
            return;
        }
        int[] array = new int[n];
        printArray(array, 0, array.length);
    }

    private void printArray(int[] array, int n, int length) {
        if (n != length) {
            for (int i = 0; i < 10; i++) {
                array[n] = i;
                printArray(array, n + 1, length);
            }
        } else {
            boolean flag = false;
            for (int i = 0; i < length; i++) {
                if (array[i] != 0) {
                    flag = true;
                }
                if (flag) {
                    System.out.print(array[i]);
                }
            }
            if (flag) {
                System.out.println();
            }
        }
    }
}

package 剑指offer;

/**
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * Created by MelloChan on 2017/12/5.
 */
public class No47 {
    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        System.out.println(solution47.sum_Solution(5));
    }
}

class Solution47 {
    public int sum_Solution(int n) {
        int result = 0;
        int a = 1;
        boolean value = ((n != 0) && a == (result = sum_Solution(n - 1)));
        result += n;
        return result;
    }

}
package 剑指offer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数。
 * Created by MelloChan on 2017/11/8.
 */
public class No32 {
    public static void main(String[] args) {
        Solution32 solution32=new Solution32();
        System.out.println(solution32.numberOf1Between1AndN(13));
    }
}

/**
 * 解决方案:
 * O(nlogn) 非最优方案 但O(logN)方案不是很理解,
 */
class Solution32 {
    public int numberOf1Between1AndN(int n) {
        int number = 0;
        for (int i = 1; i <= n; i++) {
            number += numberOf1(i);
        }
        return number;
    }

    private int numberOf1(int n) {
        int number = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                number++;
            }
            n = n / 10;
        }
        return number;
    }
}

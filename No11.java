package 剑指offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * Created by MelloChan on 2017/10/21.
 */
public class No11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.power(2, 8));
        System.out.println(solution11.power(1.1, 2));
        System.out.println(solution11.power(-1, 2));
        System.out.println(solution11.power(-2, -2));
        System.out.println(solution11.power(2, -3));
        System.out.println(solution11.power(0.0, -2));
    }
}
/*
output:
256.0
1.2100000000000002
1.0
0.25
0.125
0.0
 */

/**
 * 解决方案:
 */
class Solution11 {
    double power(double base, int exponent) {
        if (base == 0.0) {
            return 0.0;
        }
        if (exponent == 0) {
            return 1;
        }
        int abs = Math.abs(exponent);
        double result = powerWithExponent(base, abs);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    private double powerWithExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
    }
}

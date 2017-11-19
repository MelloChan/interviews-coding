package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 * Created by MelloChan on 2017/11/17.
 */
public class No40 {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 5, 6, 6, 2, 3, 4, 5, 7};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new Solution40().findNumsAppearOnce(array, num1, num2);
        System.out.println("num1: " + num1[0] + " num2 : " + num2[0]);
    }
}

/**
 * 解决方案:与No35题同样的思路,利用hashmap的特性[非最优 最优方案是使用异或思想].
 */
class Solution40 {
    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length <= 0) {
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : array) {
            Integer result = map.get(i);
            map.put(i, result == null ? 1 : result + 1);
        }
        int count = 0;
        int[] save = new int[2];
        for (Integer i : map.keySet()) {
            if (map.get(i).equals(1)) {
                save[count++] = i;
            }
        }
        num1[0] = save[0];
        num2[0] = save[1];
    }
}
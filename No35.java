package 剑指offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置
 * Created by MelloChan on 2017/11/18.
 */
public class No35 {
    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        System.out.println(solution35.firstNotRepeatingChar("google")); //l 4
        System.out.println(solution35.firstNotRepeatingChar("asdadadaswwqqsadasfftasdl")); //t 20
    }
}/*
4
20
*/

/**
 * 解决方案:利用hashmap的特性
 */
class Solution35 {
    public int firstNotRepeatingChar(String str) {
        int firstIndex = -1;
        if (str == null || str.length() <= 0) {
            return firstIndex;
        }

        Map<Character, Integer> strMap = new LinkedHashMap<>(); //按插入顺序映射的Hash表
        char[] chars = str.toCharArray();
        for (char c : chars) {
            Integer result = strMap.get(c);
            strMap.put(c, result == null ? 1 : result + 1);
        }
        char first = 0; // 记录第一个在数组中只重复一次的字符
        for (char c : strMap.keySet()) {
            if (strMap.get(c).equals(1)) {
                first = c;
                break; //找到后即退出循环
            }
        }
        for (int i = 0, length = str.length(); i < length; i++) {
            if (chars[i] == first) {
                firstIndex = i;
            }
        }
        return firstIndex;
    }
}

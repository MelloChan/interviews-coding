package 剑指offer;

import java.util.ArrayList;

/**
 * 找出所有和为S的连续正数序列(至少包括两个数)
 * Created by MelloChan on 2017/11/20.
 */
public class No42 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.findContinuousSequence(2));
        System.out.println(solution42.findContinuousSequence(9));
        System.out.println(solution42.findContinuousSequence(100000));
    }
}

/**
 * 解决方案:考虑使用small与big两个数 cruSum = small + big
 * 当 cruSum < sum big++ sum+=big big将是sum正数序列的下一个值
 * 当 cruSum > sum sum-=small ++small  small更新为sum正数序列的下一个值
 * 当 cruSum == sum 循环添加正数序列
 */
class Solution42 {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (sum < 3) {
            return arrayLists;
        }
        int small = 1, big = 2, mid = (1 + sum) / 2;
        int cruSum = small + big;
        while (small < mid) {
            if (cruSum == sum) {
                arrayLists.add(addNumber(small, big));
            }
            while (cruSum > sum && small < mid) {
                cruSum -= small;
                ++small;
                if (cruSum == sum) {
                    arrayLists.add(addNumber(small, big));
                }
            }
            ++big;
            cruSum += big;
        }
        return arrayLists;
    }

    /**
     * 循环加入适配的正数序列
     *
     * @param small
     * @param big
     * @return
     */
    private ArrayList<Integer> addNumber(int small, int big) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }
}


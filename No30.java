package 剑指offer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * Created by MelloChan on 2017/11/7.
 */
public class No30 {
    public static void main(String[] args) {
        int[] array={4,5,1,6,2,7,3,8};
        Solution30 solution30=new Solution30();
        System.out.println(solution30.getLeastNumbers(array,4));

    }
}

/**
 * 解决方案: 方案①:快排思想
 */
class Solution30{
    public ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        ArrayList<Integer>list=new ArrayList<>();
        if(input==null||input.length<=0||k<=0){
            return list;
        }
        partition(input,0,input.length-1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private void quickSort(int[] array,int left,int right){
        if(left<right){
            int mid=partition(array,left,right);
            quickSort(array,left,mid-1);
            quickSort(array,mid+1,right);
        }
    }
    private int partition(int[] array,int left,int right){
        int temp=array[left];
        while (left<right){
            while (left<right&&temp<=array[right]){
                --right;
            }
            array[left]=array[right];
            while (left<right&&temp>=array[left]){
                ++left;
            }
            array[right]=array[left];
        }
        array[left]=temp;
        return left;
    }
}

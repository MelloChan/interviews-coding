package 剑指offer;

/**
 * 圆圈中最后剩下的数字
 * Created by MelloChan on 2017/11/26.
 */
public class No45 {
    public static void main(String[] args) {
        Solution45 solution45=new Solution45();
        System.out.println(solution45.lastRemaining_Solution(5,3));
    }
}

class Solution45{
    public int lastRemaining_Solution(int n, int m) {
        if(n<1||m<1){
            return -1;
        }
        int last=0;
        for(int i=2;i<=n;i++){
            last=(last+m)%i;
        }
        return last;
    }
}

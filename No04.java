package 剑指offer;

/**
 * 实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Created by MelloChan on 2017/10/17.
 */
public class No04 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("we are happy");
        System.out.println(new Solution04().replaceSpace(str));
    }
}

/**
 * 解决方案:o(n)时间复杂度
 * 先遍历求空格数量->扩容相应大小数组[原长度+2*空格数]
 * 双指针,v1->原始数组末尾 v2->扩容后的数组末尾
 * 从尾到头遍历,arr[v1]==' '->替换为%20
 * 否则 arr[v2]=arr[v1]
 * 直到遍历完毕
 */
class Solution04 {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() <= 0) {
            return str.toString();
        }
        char[] array = str.toString().toCharArray();
        //记录空格数量
        int spaceCount = 0;
        for (char c : array) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        //构建扩充后的数组
        char[] newArray = new char[array.length + spaceCount * 2];
        //记录原数组/扩充后数组末尾索引
        int originLength = array.length - 1;
        int newLength = originLength + spaceCount * 2;
        while (originLength >= 0) {
            if (array[originLength] == ' ') { //从后向前填充%20
                newArray[newLength--] = '0';
                newArray[newLength--] = '2';
                newArray[newLength--] = '%';
            } else {  //拷贝字符到新数组
                newArray[newLength--] = array[originLength];
            }
            --originLength;
        }
        return new String(newArray);
    }
}


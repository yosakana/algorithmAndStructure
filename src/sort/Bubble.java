package sort;

/**
 * 时间复杂度  O(N^2)
 * 这个冒泡排序是
 * 从结尾开始逐个往前确定最大或最小的值
 */

public class Bubble {
    /*
        对数组a中的元素进行排序
     */
    public static void sort(Comparable[] a) {
        /*
         控制一共有几个元素参与排序
         当排序到只剩最后一个元素的时候，排序完成
            i定为数组最后一个元素
         */
        for (int i = a.length - 1; i > 0; i--) {
            for(int j = 0 ; j < i ; j++){
                //比较索引j和j+1的处的值
                if(greater(a[j] , a[j+1])){
                    exch(a , j , j+1);
                }
            }
        }
    }

    /*
        比较v元素是否大于w元素
     */
    private static boolean greater(Comparable v, Comparable w) {
        //如果result大于0就说明v大于w 反之...
        //int result = v.compareTo(w);
        return v.compareTo(w) > 0;
    }

    /*
        数组元素i和j交换位置
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

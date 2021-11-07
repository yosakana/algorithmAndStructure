package sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 1, 6, 8, 4, 7};
        sort(arr , 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //定义一个排序方法
    public static void sort(int[] arr, int left, int right) {
        //左索引不能大于右索引
        if (left > right) {
            return;
        }

        //定义基准数，每个数组的最左边第一个元素作为基准数
        int base = arr[left];
        //初始化左索引和右索引
        int i = left;
        int j = right;

        //定义循环 当i和j不相遇的时候就继续循环检索
        while (i != j) {

            //先检索右边的 要比base大或等才行 还得保证j不能越过i
            while (arr[j] >= base && j > i){
                j--;
            }

            //检索左边的
            while(arr[i] <= base && i < j){
                i++;
            }

            //交换元素
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;

        }//这个循环结束还有一步操作，把基准数和i=j位置的数交换
        arr[left] = arr[i];
        arr[i] = base;

        //递归 向左 和 向右 的排序 , i==j这里的元素已经在整个数组里排列到位，所以跳过
        sort(arr , left , i - 1);
        sort(arr , i + 1 , right);


    }
}

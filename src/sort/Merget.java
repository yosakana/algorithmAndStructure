package sort;

import java.util.Arrays;

public class Merget {

    public static void main(String[] args) {
        int[] arr = {4,2,1,6,7,5,3};
        int[] temp = new int[arr.length]; //归并排序需要内存空间
        mergetSort(arr , 0 , arr.length - 1 , temp);

        System.out.println(Arrays.toString(arr));
    }

    //分+合方法
    public static void mergetSort(int[] arr , int left , int right , int[] temp){

        if (left < right){
            int mid = (left + right) / 2;
            //向左分解       左边界   中间
            mergetSort(arr , left , mid , temp);
            //向右分解       右边数组的左边界  最右边界
            mergetSort(arr , mid + 1 , right , temp);
            //合并
            merget(arr , left , mid , right , temp);
        }
    }


    /**  分的方法
     *
     *   left 4 2 1 6 mid 7 9 5 3 right
     *
     * @param arr   待排序的数组
     * @param mid   中间索引
     * @param left  最左边的索引
     * @param right 最右边的索引
     * @param temp  中转的数组
     */
    public static void merget(int[] arr , int left , int mid , int right , int[] temp){
        int i = left;       //初始化数组最左边的索引
        int j = mid + 1;    //初始化第二个待排序数组的左边索引
        int t = 0;          //中转数组的下标

        //如何判断此次合并有没有结束
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }


        //循环完，必定剩下还没有添加进temp数组的数
        while(i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }

        while(j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        System.out.println(Arrays.toString(temp)+"|| temp");


        //将temp数组拷贝回arr数组
        //这个算法本质上是对 《同一个》 数组进行操作，不管是分 (同一个数组只是在索引上划分成了多个数组)
        //还是合，都是同一个数组
        //所以在从temp数组拷贝回去的时候，需要对左右边界进行区分，不然会有一些索引上的问题

        while(left <= right){
            arr[left] = temp[t];
            t++;
            left++;
        }

        System.out.println(Arrays.toString(arr)+"|| arr");
    }
}

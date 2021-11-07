package sort;

public class HeapSort {
    public static void main(String[] args) {

    }

    //排序
    public static void heapSort(int arr[]) {
        //先进行大顶堆的调整
        //先从最后一个非页子节点开始  最后两个任意一个除以2再-1 奇数int类型会舍去小数点后
        //完全二叉树，不会存在只有右没有左的情况
        for(int i = arr.length / 2 - 1 ;  i > 0 ; i--){
            adjustHeap(arr , i , arr.length);
        }

        /* 排序规则:
              堆顶和末尾元素比较，大的沉底，小的往堆顶去
              此时已经是大顶堆的状态了
        */

        int temp = 0;
        for(int j = arr.length - 1 ; j > 0 ; j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            
            /*
                难以理解
             */
            adjustHeap(arr , 0 , j);
        }

    }


    /**
     * 调整大顶堆
     *
     * @param arr    待调整数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 剩余待调整的元素个数
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //先保存当前非叶子节点
        int temp = arr[i];

        //一直找当前非叶子节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //这一步主要判断左子节点是否比右子节点要小
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            //开始进行元素之间的交换（实现过程有点类似于 插入排序）
            if(arr[k] > arr[i] ){
                arr[i] = arr[k];
                i = k;     //原来i位置已经被k替换了，所以原来i要替换的元素位置只能下一步的k
            }
        }
        //也就是替换原来k位置的元素
        arr[i] = temp;
    }


    //二分查找(必须是有序)
    public static void binarySearch(int[] arr , int left , int right , int value){
        
    }

    //二分查找含有重复元素
    public static void duplicateElementBinarySearch(){

    }

}

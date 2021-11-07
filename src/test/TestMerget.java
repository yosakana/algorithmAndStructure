package test;

import java.util.Arrays;

public class TestMerget {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 5, 6, 9, 8, 7};
        int[] temp = new int[arr.length];

        mergetSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    //分，分+和
    public static void mergetSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左分解       左边界   中间
            mergetSort(arr, left, mid, temp);
            //向右分解       右边数组的左边界  最右边界
            mergetSort(arr, mid + 1, right, temp);
            //合并
            merget(arr, left, mid, right, temp);
        }
    }

    //和
    public static void merget(int[] arr, int left, int mid, int right, int[] temp) {
        //实际上是分成了三个数组，所以需要三个指向数组元素的指针
        int i = left; //第一个
        int j = mid + 1; //第二个
        int t = 0; //待排数组

        //按规律填充到temp数组中
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        t = 0;
        while (left <= right) {
            arr[left] = temp[t];
            t++;
            left++;
            System.out.println(1);
        }
    }
}

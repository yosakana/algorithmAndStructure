package test;

import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 7, 6, 4, 3, 1};
        int[] temp = new int[arr.length];
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void shellSort(int[] arr) {
        int h = 1;
        while (h < arr.length / 2) {
            h = h * 2 + 1;
        }


        while (h > 0) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j] < arr[j - h]) {
                        int temp = 0;
                        temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    }
                }
            }
            h = h / 2;
        }


    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        int beforeIndex = 0;
        int insertNum = 0;
        for (int i = 1; i < arr.length; i++) {
            beforeIndex = i - 1;
            insertNum = arr[i];
            while (beforeIndex >= 0 && arr[beforeIndex] > insertNum) {
                arr[beforeIndex + 1] = arr[beforeIndex];
                beforeIndex--;
            }

            arr[beforeIndex + 1] = insertNum;
        }
    }

    public static void selectSort(int[] arr) {
        int miniIndex = 0;
        int miniVal = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            miniVal = arr[i];
            miniIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < miniVal) {
                    miniIndex = j;
                    miniVal = arr[j];
                    flag = true;
                }
            }

            if (flag) {
                arr[miniIndex] = arr[i];
                arr[i] = miniVal;
                flag = false;
            }
        }
    }

    public static void mergetSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergetSort(arr, left, mid, temp);
            mergetSort(arr, mid + 1, right, temp);

            merget(arr, left, mid, right, temp);
        }
    }

    public static void merget(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

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

        int templeft = left;
        t = 0;
        while (templeft <= right) {
            arr[templeft] = temp[t];
            t++;
            templeft++;
        }


    }

    public static void quickSort(int[] arr, int left, int right) {

        if(left > right){
            return;
        }

        int base = arr[left];
        int i = left;
        int j = right;

        while(i != j){
            while(arr[j] >= base && j > i){
                j--;
            }
            while(arr[i] <= base && j > i){
                i++;
            }



            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        arr[left] = arr[i];
        arr[i] = base;

        //递归 向左 和 向右 的排序 , i==j这里的元素已经在整个数组里排列到位，所以跳过
        quickSort(arr , left , i - 1);
        quickSort(arr , i + 1 , right);
    }
}

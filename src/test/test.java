package test;

import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println(0 / 10);
    }

    //冒泡
    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {
                flag = false;
            } else {
                break;
            }
        }
    }


    //插入
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int beforeInsertIndex = i - 1;

            //                    要大于等于0，第一个数是1,1-1=0，直到2的时候才会执行下列循环
            while (beforeInsertIndex >= 0 && arr[beforeInsertIndex] > insertVal) {
                arr[beforeInsertIndex + 1] = arr[beforeInsertIndex];

                beforeInsertIndex--;
            }

            arr[beforeInsertIndex + 1] = insertVal;

        }
    }


    //选择
    public static void selectSort(int[] arr) {
        int minVal = 0;
        int minIndex = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            minVal = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minIndex = j;
                    minVal = arr[j];
                    flag = true;
                }
            }

            if (flag) {
                arr[minIndex] = arr[i];
                arr[i] = minVal;

                flag = false;
            }
        }
    }


    //归并
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


        //&&和||还需要加强理解
        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;

            } else {
                temp[t] = arr[j];
                j++;
                t++;

            }

        }

        while (i <= left) {
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        t = 0;
        while (left <= right) {
            arr[left] = temp[t];
            t++;
            left++;
        }
    }


    //快排
    public static void quickSort(int[] arr, int left, int right) {

        //递归操作的停止条件
        if (left >= right) {
            return;
        }

        int base = arr[left];
        int i = left;
        int j = right;

        while (i != j) {

            while (arr[j] >= base && j > i) {
                j--;
            }

            while (arr[i] <= base && j > i) {
                i++;
            }

            int temp = 0;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

        arr[left] = arr[i];
        arr[i] = base;


        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }


    //堆
    public static void heapSort() {

    }

    public static void heap() {

    }


    //希尔
    public static void shellSort(int[] arr) {
        int h = 1;

        while (h < arr.length / 2) {
            h = h * 2 + 1;
        }

        while (h > 0) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j - h] > arr[j]) {
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


    //基数
    //TODO
}


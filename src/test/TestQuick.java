package test;

import java.util.Arrays;

public class TestQuick {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 6, 7, 5, 4};
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quick(int[] arr, int left, int right) {

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

            while (arr[i] <= base && j > i){
                i++;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        int temp = 0;
        arr[left] = arr[i];
        arr[i] = base;

        quick(arr , left , i - 1);
        quick(arr , left + 1 , right);

    }
}

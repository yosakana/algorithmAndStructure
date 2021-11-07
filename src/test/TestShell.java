package test;

import org.junit.Test;

import java.util.Arrays;

public class TestShell {
    public static void main(String[] args) {
        int[] ints = {3, 1, 2, 4, 6, 5 , 7 , 8 ,11};
        TestShell.sort(ints);

        System.out.print(Arrays.toString(ints));
    }


    public static void sort(int[] arr) {
        int h = 1;
        while (h < arr.length / 2) {
            System.out.println(h);
            h = h * 2 + 1;
        }

        while (h > 0) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j - h] > arr[j]) {
                        int temp = arr[j - h];
                        arr[j - h] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            h = h / 2;
        }

    }
}

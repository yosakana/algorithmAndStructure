package test;

import sort.BubbleSort冒泡改良;

import java.util.Arrays;

public class TestBubble {
    public static void main(String[] args) {
        Integer[] ints = {3,2,1,4,5,6,7};
        BubbleSort冒泡改良.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}

package test;

import sort.Insert;

import java.util.Arrays;

public class TestInsert {
    public static void main(String[] args) {
        Integer[] ints = {5, 2, 7, 6, 4, 3, 1};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void sort(Integer[] a){
        //待插入数的前一位下标
        int befIndex;
        //***********
        //必须定义一个数字来保存待插入数
        //否则在while循环中数字会被beforeIndex的数给顶替掉
        int inserNum;

        for(int i = 1 ; i < a.length ; i++){

            inserNum = a[i];
            befIndex = i - 1;

            while(befIndex >= 0 && a[befIndex] > inserNum){
                a[befIndex + 1] = a[befIndex];
                befIndex--;
            }


            a[befIndex + 1] = inserNum;

        }
    }
}

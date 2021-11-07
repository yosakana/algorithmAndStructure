package sort;

import java.util.Arrays;

public class Radix {
    public static void main(String[] args) {
        int[] arr = new int[]{53, 3, 542, 748, 14, 214,1};
        test(arr);
        System.out.println(Arrays.toString(arr));
    }

    //思路分析
    public static void radixSort(int[] arr) {
        //通过一个二维数组来标识 桶的个数 和 每个桶里得出的元素个位或者其他位的下标
        int[][] bucket = new int[10][arr.length];

        //定义一个一维数组来记录每个桶中的元素个数
        //第几个桶里有几个元素 所以是10
        int[] bucketElementCounts = new int[10];

        //针对待排数组的元素进行处理
        for (int i = 0; i < arr.length; i++) {

            //1.求得每个元素的个位 对10取模
            int dightOfElement = arr[i] % 10;

            //放入桶中 第个位数个桶，然后是该元素在桶中的位置（个位数的下标）
            bucket[dightOfElement][bucketElementCounts[dightOfElement]] = arr[i];
            //数组初始化每个元素位置是0 ， 上一步是第一轮
            //所以先存在0的位置了，下一步需要把存储位置的指针下移
            bucketElementCounts[dightOfElement]++;
        }

        //按照这个顺序，依次取出放回原来的数组，也就是第一轮排序
        int index = 0;
        //用index来表示原来待排数组的位置 j来遍历桶中元素
        for (int j = 0; j < bucketElementCounts.length; j++) {

            //判断桶中是否有元素，节省时间
            if (bucketElementCounts[j] != 0) {
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    arr[index] = bucket[j][k];
                    index++;
                }
            }

            //每处理完一个桶就清空当前桶的所有元素
            bucketElementCounts[j] = 0;

        }

        //第二轮 对十位进行操作
        for (int i = 0; i < arr.length; i++) {
            int dightOfElement = arr[i] / 10 % 10;
            bucket[dightOfElement][bucketElementCounts[dightOfElement]] = arr[i];
            bucketElementCounts[dightOfElement]++;
        }


        index = 0;
        for (int j = 0; j < bucketElementCounts.length; j++) {

            if (bucketElementCounts[j] != 0) {
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    arr[index] = bucket[j][k];
                    index++;
                }
            }

            bucketElementCounts[j] = 0;

        }

        //第三轮 对百位进行操作
        for (int i = 0; i < arr.length; i++) {
            int dightOfElement = arr[i] / 100 % 10;
            bucket[dightOfElement][bucketElementCounts[dightOfElement]] = arr[i];
            bucketElementCounts[dightOfElement]++;
        }


        index = 0;
        for (int j = 0; j < bucketElementCounts.length; j++) {

            if (bucketElementCounts[j] != 0) {
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    arr[index] = bucket[j][k];
                    index++;
                }
            }

            bucketElementCounts[j] = 0;

        }
    }

    //最终的基数排序
    public static void realRadixSort(int[] arr) {

        //首先要确认最大的数有几位，然后确定需要几轮排序
        int max = arr[0];
        for (int x = 1; x < arr.length; x++) {
            if (arr[x] > max) {
                max = arr[x];
            }
        }
        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];

        //重点
        for (int i = 0, n = 1; i < maxLength; i++, n = n * 10) {

            //针对待排数组的元素进行处理
            for (int j = 0; j < arr.length; j++) {


                int dightOfElement = arr[j] / n % 10;

                //放入桶中 第个位数个桶，然后是该元素在桶中的位置（个位数的下标）
                bucket[dightOfElement][bucketElementCounts[dightOfElement]] = arr[j];
                //数组初始化每个元素位置是0 ， 上一步是第一轮
                //所以先存在0的位置了，下一步需要把存储位置的指针下移
                bucketElementCounts[dightOfElement]++;
            }

            //按照这个顺序，依次取出放回原来的数组，也就是第一轮排序
            int index = 0;
            //用index来表示原来待排数组的位置 j来遍历桶中元素
            for (int j = 0; j < bucketElementCounts.length; j++) {

                //判断桶中是否有元素，节省时间
                if (bucketElementCounts[j] != 0) {
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }

                //每处理完一个桶就清空当前桶的所有元素
                bucketElementCounts[j] = 0;
            }
        }
    }

    public static void test(int[] arr) {

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength = (max + "").length();

        //初始化桶，和桶的有效元素数组
        int[][] bucket = new int[10][arr.length];

        int[] elementsInBucket = new int[10];

        //处理几轮
        for (int j = 0, n = 1; j < maxLength; j++, n = n * 10) {
            //处理数据
            for (int k = 0; k < arr.length; k++) {

                int dightOfElement = arr[k] / n % 10;

                bucket[dightOfElement][elementsInBucket[dightOfElement]] = arr[k];

                elementsInBucket[dightOfElement]++;
            }

            //index表示的是原待排数组的下标，要一一进行替换
            int index = 0;
            for (int k = 0; k < elementsInBucket.length; k++) {

                if (elementsInBucket[k] != 0) {
                    for (int l = 0; l < elementsInBucket[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }

                elementsInBucket[k] = 0;
            }
        }
    }


}

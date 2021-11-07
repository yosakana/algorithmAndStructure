package search;

import java.util.ArrayList;
import java.util.List;

//二分查找的前提必须是有序数组
public class BinarySearch {
    public static void main(String[] args) {
        //有序数组 有序数组 有序数组 必须得升序排列
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int i = binarySearch(arr, 0, arr.length - 1, 9);
        System.out.println(i);
    }

    //返回的是数组下标
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }

    public static List binarySearchP(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        List<Integer> res = new ArrayList<Integer>();

        if (findVal > midVal) {
            return binarySearchP(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearchP(arr, left, mid - 1, findVal);
        } else {
            //在已经找到符合findVal的mid情况下，对左和对右进行扫描，取出所有符合元素的下标

            int temp = mid;

            //先比较中间
            if(arr[temp] == midVal){
                res.add(arr[temp]);
            }

            //再往左遍历
            while(arr[temp - 1] == midVal){
                res.add(arr[temp - 1]);
                temp--;
            }

            //往右遍历
            temp = mid;
            while(arr[temp + 1] == midVal){
                res.add(arr[temp + 1]);
                temp++;
            }

            return res;
        }

    }
}

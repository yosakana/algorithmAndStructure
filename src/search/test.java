package search;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,6,6,9,10};
        List<Integer> list = binarySearchList(arr, 0, arr.length - 1, 6);
        System.out.println(list);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if(left > right){
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

    public static List<Integer> binarySearchList(int[] arr , int left , int right , int findVal){
        if(left > right){
            return null;
        }

        List<Integer> valList = new ArrayList<Integer>();

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if(findVal < midVal){
            return binarySearchList(arr , left , mid - 1 , findVal);
        }else if(findVal > midVal){
            return binarySearchList(arr , mid + 1 , mid + 1 , findVal);
        }else{

            int temp = mid;

            if(arr[temp] == midVal){
                valList.add(arr[temp]);
            }

            while(arr[temp - 1] == midVal){
                valList.add(arr[temp - 1]);
                temp--;
            }

            temp = mid;
            while(arr[temp + 1] == midVal){
                valList.add(arr[temp + 1]);
                temp++;
            }

            return valList;

        }



    }
}

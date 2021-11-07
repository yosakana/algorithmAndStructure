package sort;

/*
  时间复杂度 O(N^2)
 */

public class Select {

    public static void sort(Comparable[] a){
        int minIndex;
        for(int i = 0 ; i < a.length - 1 ; i++){
            minIndex = i;
            for(int j = i + 1 ; j < a.length ; j++){
                if(greater(a[minIndex] , a[j])){
                    minIndex = j;
                }
            }

            if(minIndex != i){
                exch(a , i , minIndex);
            }
        }
    }

    //比较返回较大的值
    public static boolean greater(Comparable v , Comparable w){
        return v.compareTo(w) > 0;
    }

    //元素交换
    public static void exch(Comparable[] a , int i , int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

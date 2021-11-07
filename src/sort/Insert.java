package sort;

// 时间复杂度 O(N^2)

public class Insert {
    public static void sort(Comparable[] a){
        //待插入数的前一位下标
        int befIndex;
        Comparable insertNum;
        for(int i = 1 ; i < a.length ; i++){
            insertNum = a[i];
            befIndex = i - 1;
            while(befIndex >= 0 && greater(a[befIndex] , insertNum)){
                a[befIndex + 1] = a[befIndex];
                befIndex--;
            }
            a[befIndex + 1] = insertNum;
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

package sort;

public class BubbleSort冒泡改良 {
    public static void sort(Comparable[] a){
        boolean flag = false;
        //4 2 1 3
        for(int i = a.length - 1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if(greater(a[j] , a[j+1])){
                    exch(a , j , j+1);
                    flag = true;
                }
            }

            if(flag){
                flag = false;
            }else{
                break;
            }
        }
    }

    public static boolean greater(Comparable a , Comparable b){
        return a.compareTo(b) > 0;
    }

    public static void exch(Comparable[] a , int i , int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

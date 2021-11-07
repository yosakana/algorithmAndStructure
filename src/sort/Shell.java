package sort;

public class Shell {
    public static void sort(Comparable[] a) {
        //对增长量的确定
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }
        //希尔排序
        while (h >= 1) {
            //首先先找到每一个待插入元素
            //每一组都是先从h的下标开始
            for (int i = h; i < a.length; i++) {
                System.out.println("h"+":"+h+"||"+"i"+":"+i);
                //把待插入元素插入到有序数列中
                for (int j = i; j >= h; j = j - h) {
                    System.out.println("j"+":"+j);
                    //比较a[j]和a[j-h]
                    if (greater(a[j], a[j - h])) {
                        exch(a, j, j - h);
                    }
//                    else{
//                        break;
//                    }
                }
            }
            //对增长量的递减
            h = h / 2;
        }
    }

    //比较返回较大的值
    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    //元素交换
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

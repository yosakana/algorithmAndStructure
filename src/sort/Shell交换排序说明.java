package sort;

public class Shell交换排序说明 {
    public static void sor(int[] arr){
        //定义步长
        int h = 1;
        //步长递增
        while(h < arr.length){
            h = h*2 + 1;
        }

        while (h > 1){
            int temp = 0;
            //通过步长确认第一个需要排序的数     依次往后遍历需要排序的数
            for(int i = h ; i < arr.length ; i++){
                //通过 j= j -h 来确认每个与当前数相对应需要比较的数
                for(int j = i ; j >= h ; j -= h){
                    if(arr[j] < arr[j - h]){
                        temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    }else{
                        //当这个数不小于时就break,break就说明单组数字已经排列到位，需要进行下一组的排列
                        //结束的不是是单个数字的对比 --> 如果下标第五位，步长为2的话，交换之后,还需要让交换之后的下标3和下标1进行对比
                        /*
                        这个循环是通过内部j循环进行单个对比
                        外部i循环控制往后推进数字的选择
                         */


                        /**不能break**/
                        //如果待排数组为 1 3 2 的话，1 < 3 就直接break掉了，2就没法交换了
//                        break;
                    }
                }
            }

            //步长递减
            h = h/2;
        }


    }
}

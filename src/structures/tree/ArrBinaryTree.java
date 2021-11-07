package structures.tree;

public class ArrBinaryTree {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        顺序BinaryTree bt = new 顺序BinaryTree(arr);
        bt.preOrder(0);
    }

}

class 顺序BinaryTree {
    private int[] arr;

    public 顺序BinaryTree(int[] arr){
        this.arr = arr;
    }

    //顺序存储二叉树的前序遍历
    public void preOrder(int index){

        //数组为空的情况，或数组为0
        /* 为什么判断完空，还要判断数组长度的问题 */
        /* ||和&&的短路原则，如果数组为null，则没有进行初始化，如果初始化了
           就判断长度是否为0，如果只判断长度的话，会有空指针异常 */
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }

        //先打印自己,从index下标开始
        System.out.println(arr[index]);

        //向左递归
        if((index * 2 + 1) < arr.length){
            preOrder(2 * index + 1);
        }

        //向右递归
        if((index * 2 + 2) < arr.length){
            preOrder(2 * index + 2);
        }

    }

    //中序
    public void midOrder(int index){

        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }


        //向左递归
        if((index * 2 + 1) < arr.length){
            midOrder(2 * index + 1);
        }

        //打印自己,从index下标开始
        System.out.println(arr[index]);

        //向右递归
        if((index * 2 + 1) < arr.length){
            midOrder(2 * index + 2);
        }

    }

    //后序
    public void postOrder(int index){

        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }


        //向左递归
        if((index * 2 + 1) < arr.length){
            postOrder(2 * index + 1);
        }

        //向右递归
        if((index * 2 + 1) < arr.length){
            postOrder(2 * index + 2);
        }

        //打印自己,从index下标开始
        System.out.println(arr[index]);
    }
}

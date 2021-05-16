package 匿名内部类;

public class Main {
    public static void main(String[] args) {
        /**
         * 适用：1.只需要调用一次的接口
         *      2.不需要再定义接口的实现类
         */
        MyInterface imp = new MyInterface() {
            @Override
            public void print() {
                System.out.println("匿名内部类实现");
            }
        };

        /**
         * 这种方式使用了匿名内部类。而且省略了对象名称，也是匿名对象
         */
        new MyInterface(){
            @Override
            public void print() {

            }
            //直接调用方法
        }.print();

    }
}

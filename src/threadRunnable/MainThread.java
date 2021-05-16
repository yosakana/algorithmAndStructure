package threadRunnable;

public class MainThread {
    public static void main(String[] args) {
        //创建接口实现类对象
        MyThreadRunnable mtr = new MyThreadRunnable();

        //创建线程对象,使用带参构造方法
        Thread thread = new Thread(mtr);

        //开启线程
        thread.start();

        //有时调用Thread(Runnable)构造方法时，实参也会传递匿名内部类对象
        Thread thread2 = new Thread(new MyThreadRunnable(){
            @Override
            public void run() {
                System.out.println("匿名类对象");
            }
        });
        thread2.start();


    }
}

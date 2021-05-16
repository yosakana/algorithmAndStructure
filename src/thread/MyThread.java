package thread;

public class MyThread extends Thread{
    //在子类中重写Thread类的run方法，设置线程任务（开启线程要做什么？）

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run:"+i);
        }
    }
}

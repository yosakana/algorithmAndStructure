package thread;

/**
 * 创建多线程程序的第一种方式：创建Thread类的子类
 * java.lang.Thread类：描述线程的类，我们想要实现多线程的类，必须继承Thread类
 *
 * Step：
 *      1.创建一个Thread类的子类
 *      2.在Thread类的子类中重写Thread类中的run方法，设置线程任务（开启线程做什么）
 *      3.创建Thread类的子类对象
 *      4.调用Thread类中的方法start方法，开启新的线程，执行run方法
 *
 * java程序属于抢占式调度，哪个线程的优先级高，哪个线程优先执行;同一个优先级，随机选择一个执行
 */

public class DemoThread {
    public static void main(String[] args) {
//        MyThread mt = new MyThread();
//        mt.start();
//
//        for (int i = 0; i < 20; i++) {
//            System.out.println("main:"+i);
//        }
        MyThread02 mt = new MyThread02();
        mt.start();

        new MyThread02().start();
    }
}

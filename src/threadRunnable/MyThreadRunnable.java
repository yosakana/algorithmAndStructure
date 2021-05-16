package threadRunnable;

/**
 * 当线程类已经有父类了，就不能用继承Thread类的形式创建线程，
 * 可以用实现Runnable接口的形式
 * 1)定义类实现Runnable接口
 */

public class MyThreadRunnable implements Runnable{
    //重写接口中的抽象方法run()
    @Override
    public void run() {

    }
}

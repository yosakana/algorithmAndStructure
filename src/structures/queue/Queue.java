package structures.queue;

public class Queue {
    private static final int DEFAULT_CAPACITY = 8;
    private Object[] elements; //数据保存数据
    private int front;  //队首指针
    private int rear;   //队尾指针
    private int size;   //队列中元素个数

    public Queue() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public Queue(int capacity) {
        elements = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //入队
    public void enQueue(Object e) {
        if (size >= elements.length) {
            expandQueue();
        }

        elements[rear] = e;

        rear = (rear + 1) % elements.length;
        size++;
    }

    //扩容
    private void expandQueue() {
        Object[] newElement = new Object[elements.length * 2];

        for (int i = 0; i < elements.length; i++) {
            newElement[i] = elements[i];
        }

        elements = newElement;

        //调整新的队首队尾指针
        front = 0;
        rear = size;

    }

    //出队
    public Object deQueue() {
        if (size <= 0) {
            //抛出一个队列为空的异常
        }

        //队列不为空，把front指向的元素返回
        Object old = elements[front];
        front = (front + 1) % elements.length;
        size--;

        return old;
    }

    //返回队首元素
    public Object peek() {
        return elements[front];
    }

}

package structures.linear;

import java.util.Arrays;

public class SequentialList<T> {
    //存储元素的数组
    private T[] elements;
    //记录当前顺序表中的元素个数
    private int N = 0;

    //构造方法
    public SequentialList(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.N = 0;
    }

    //线性表扩容
    public void expand() {
        T[] newElement = (T[]) new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElement[i] = elements[i];
        }
        this.elements = newElement;
    }

    //清空线性表
    public void clear() {
        this.N = 0;
    }

    //判断当前线性表是否为空
    public boolean isEmpty() {
        return N == 0;
    }

    //获取线性表的长度
    public int length() {
        return N;
    }

    //获取指定位置的元素
    public T get(int i) {
        return elements[i];
    }

    //向线性表中添加元素
    public void insert(T t) {
        if (N >= elements.length) {
            expand();
        }

        elements[N] = t;
        N++;
    }

    //向指定位置添加元素
    public void insert(T t, int index) {
        if (N >= elements.length) {
            expand();
        }
        int insertIndex = index;

        for(int i = N ; i > index ; i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = t;
        N++;
    }

    //删除指定索引i处的元素
    public T remove(int index){
        T ele = elements[index];

        for(int i = index + 1 ; i < N + 1; i ++){
            elements[i - 1] = elements[i];
        }

        N--;
        return ele;
    }

    //查找元素在线性表中第一次出现的位置
    public int indexOf(T t){
        for(int i = 0 ; i < N ; i++){
            if(elements[i] == t){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "SequenceList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}

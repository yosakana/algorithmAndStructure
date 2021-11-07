package structures.linear;

public class LinkedList {
    private Node head;
    private int length = 0;

    public LinkedList(Node node){
        this.head = node;
        length++;
    }

    //清空链表
    public void clear(){
        head = null;
        length = 0;
    }

    //判断线性表是否为空
    public boolean isEmpty(){
        return length == 0;
    }

    //读取并返回链表中的第i个元素的值
    public Object get(int index){
        if(head == null){
            System.out.println("链表为空");
        }

        if(index == 0){
            return head.data;
        }

        Node resNode = null;
        Node temp = head;
        for(int i = 0 ; i < index ; i++){
            temp = temp.next;
            resNode = temp;
        }

        return resNode.data;
    }

    //在链表表尾中插入一个元素
    public void insert(Node node){
        Node temp = head;
        for(int i = 0 ; i < length - 1; i++){
            temp = temp.next;
        }
        temp.next = node;
        length++;
    }

    //在索引i之前插入一个元素
    public void insert(int index , Node node){
        if(head == null){
            System.out.println("链表为空");
        }
        Node temp = head;
        for(int i = 0 ; i < index - 1 ; i++){
            temp = temp.next;
        }
        temp.next = node;
        length++;
    }

    //删除并返回链表中第i个数据元素
    public Node remove(int index){

        Node temp = head;

        if(index == 0){
            head = head.next;
        }


        for(int i = 0 ; i < index - 1 ; i++){
            temp = temp.next;
        }

        Node curr = null;
        Node nextNode = temp.next.next;
        curr = temp.next;

        nextNode.next = temp;


        return curr;
    }

    //返回链表中首次出现的指定的数据元素的位序号
    public int indexOf(Node node){
        Node temp = head;
        for(int i = 0 ; i < length - 1 ; i++){
            if(temp == node){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }



}

 class Node{
    public Node next;
    public Object data;

    public Node(Node next , Object data){
        this.next = next;
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
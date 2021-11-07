package structures.hashTable;

import java.util.Hashtable;

public class HashTable {
    public static void main(String[] args) {

    }
}

//HashTable中等级最高的类
class HashTab{
    //定义一个存储所有链表的数组
    EmpLinkedList[] empLinkedLists;
    //链表长度
    int size = 0;


    //初始化链表数组
    public HashTab(int size){
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];

        /* 有一个坑(链表初始化) 没有构建类的对象 */
        for(int i = 0 ; i < size ; i ++){
            empLinkedLists[i] = new EmpLinkedList();
        }

    }

    //添加雇员
    public void add(Emp emp){
        //通过散列函数，得到员工应该添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        /* 这里如果在初始化链表数组时没有对链表进行初始化 */
        /* 会出现链表为空的状况，因为没有对链表进行初始化 */
        empLinkedLists[empLinkedListNo].add(emp);
    }

    //遍历链表
    public void list(){
        for(int i = 0 ; i < size ; i++){
            empLinkedLists[i].list();
        }
    }

    //根据id，查找雇员
    public void findEmById(int id){
        //使用散列函数确定到哪条链表查找
        int i = hashFun(id);
        Emp emp = empLinkedLists[i].findEmpById(i);
        if(emp != null){
            System.out.println("在"+i+1+"条链表中找到该雇员");
        }else{
            System.out.println("未找到");
        }
    }
    //根据id删除雇员
    public void del(int i){
        int employId = hashFun(i);
        Emp del = empLinkedLists[employId].del(i);

        if(del != null){
            System.out.println("成功删除该雇员");
        }else{
            System.out.println("没有该雇员");
        }
    }

    //编写散列函数，使用取模法
    public int hashFun(int id){
        return id % size;
    }
}


//雇员类
//本质是一个单链表指向下一个Emp对象
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//链表头结点实际上是数组中的元素
class EmpLinkedList {
    public Emp head;

    //插入链表节点,默认插入链表末端
    public void add(Emp emp){
        if(head == null){
            head = emp;
        }
        Emp temp = head;
        while(true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = emp;
    }

    //遍历雇员信息
    public void list(){
        if(head == null){
            System.out.println("当前链表为空");
            return;
        }

        Emp temp = head;
        while(true){
            System.out.println("当前节点id为"+temp.id+",名字为"+temp.name);
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }

    }

    //根据id查找雇员
    public Emp findEmpById(int id){
        if(head == null){
            System.out.println("该链表为空");
            return null;
        }

        Emp temp = head;
        while(true){
            if(temp.id == id){
                return temp;
            }
            if(temp.next == null){
                return null;
            }
            temp = temp.next;
        }

    }

    //根据id删除链表雇员
    public Emp del(int id){
        if(head == null){
            System.out.println("链表为空");
        }

        Emp temp = head;
        while(true){
            if(temp.next.id == id){
                break;
            }
            if(temp.next.next == null){
                return null;
            }
            temp = temp.next;
        }

        Emp oldEmp = temp.next;
        if(temp.next.next == null){
            temp.next = null;
        }else{
            temp.next = temp.next.next;
        }

        return oldEmp;

    }

}





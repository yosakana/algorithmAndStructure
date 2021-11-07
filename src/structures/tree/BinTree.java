package structures.tree;


public class BinTree {

}

class BinaryTree{
    private Node root;

    public void isEmpty(){
        if(root == null){
            System.out.println("二叉树为空");
        }
    }

    //前序遍历
    public void preOrder(){
        isEmpty();
        root.preOrder();
    }
    //中序遍历
    public void midOrder(){
        isEmpty();
        root.midOrder();
    }
    //后序遍历
    public void postOrder(){
        isEmpty();
        root.postOrder();
    }

    //前序查找
    public Node preOrderSearch(Object e){
        isEmpty();
        return root.preOrderSearch(e);
    }
    //中序查找
    public Node midOrderSearch(Object e){
        isEmpty();
        return root.midOrderSearch(e);
    }
    //后序查找
    public Node postOrderSearch(Object e){
        isEmpty();
        return root.postOrderSearch(e);
    }

    //删除节点
    public void delNode(Object data){
        if(root == null){
            System.out.println("空树");
        }

        if(root.getData() == data){
            root = null;
        }else{
            root.delNode(data);
        }
    }

}

class Node{
    //二叉树里一般存储的数据形式是 key-value 的形式

    private Node leftNext;
    private Node rightNext;
    private Object data;

    public Node(){

    }

    public Node(Node leftNext , Node rightNext , Object data){
        this.data = data;
        this.leftNext = leftNext;
        this.rightNext = rightNext;
    }

    public void setLeftNext(Node leftNext) {
        this.leftNext = leftNext;
    }

    public void setRightNext(Node rightNext) {
        this.rightNext = rightNext;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public Node getLeftNext() {
        return leftNext;
    }

    public Node getRightNext() {
        return rightNext;
    }

    public Object getData() {
        return data;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);

        if(this.leftNext != null){
            this.leftNext.preOrder();
        }

        if(this.rightNext != null){
            this.rightNext.preOrder();
        }

    }
    //中序遍历
    public void midOrder(){

        if(this.leftNext != null){
            this.leftNext.midOrder();
        }

        System.out.println(this);

        if(this.rightNext != null){
            this.rightNext.midOrder();
        }

    }
    //后序遍历
    public void postOrder(){
        if(this.leftNext != null){
            this.leftNext.postOrder();
        }


        if(this.rightNext != null){
            this.rightNext.postOrder();
        }

        System.out.println(this);
    }

    //前序查找
    public Node preOrderSearch(Object e){
        if(this.data == e){
            return this;
        }

        Node resNode = null;
        if(this.leftNext != null){
            resNode =  this.leftNext.preOrderSearch(e);
        }

        if(resNode!=null){
            return resNode;
        }

        if(this.rightNext != null){
            resNode = this.rightNext.preOrderSearch(e);
        }

        return resNode;
    }
    //中序查找
    public Node midOrderSearch(Object e){

        Node resNode = null;
        if(this.leftNext != null){
            resNode =  this.leftNext.preOrderSearch(e);
        }

        if(resNode!=null){
            return resNode;
        }

        if(this.data == e){
            return this;
        }

        if(this.rightNext != null){
            resNode = this.rightNext.preOrderSearch(e);
        }

        return resNode;
    }
    //后序查找
    public Node postOrderSearch(Object e){
        Node resNode = null;
        if(this.leftNext != null){
            resNode =  this.leftNext.preOrderSearch(e);
        }

        if(resNode!=null){
            return resNode;
        }


        if(this.rightNext != null){
            resNode = this.rightNext.preOrderSearch(e);
        }

        if(this.data == e){
            return this;
        }

        return resNode;
    }

    //节点的删除
    public void delNode(Object data){

        //先看该节点的左右子节点是否就是想要删除的
        if(this.leftNext != null && this.leftNext.data == data){
            this.leftNext = null;
            return;
        }

        //然后看右节点
        if(this.rightNext != null && this.rightNext.data == data){
            this.rightNext = null;
            return;
        }

        //对左子树进行递归删除
        if(this.leftNext != null){
            this.leftNext.delNode(data);
        }

        if(this.rightNext != null){
            this.rightNext.delNode(data);
        }


    }





}

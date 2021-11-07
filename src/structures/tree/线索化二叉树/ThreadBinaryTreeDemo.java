package structures.tree.线索化二叉树;

public class ThreadBinaryTreeDemo {
    public static void main(String[] args) {
        Node node6 = new Node();
        node6.setData(6);
        Node node5 = new Node();
        node5.setData(5);
        Node node4 = new Node();
        node4.setData(4);
        Node node3 = new Node();
        node3.setData(3);
        Node node2 = new Node();
        node2.setData(2);
        Node node1 = new Node();
        node1.setData(1);

        node1.setLeftNext(node2);
        node2.setLeftNext(node3);
        node2.setRightNext(node4);
        node1.setRightNext(node5);
        node5.setLeftNext(node6);

        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.setRoot(node1);
        threadBinaryTree.threadedNodes(node1);

        System.out.println(node2.getRightType());

        threadBinaryTree.threadedList();
    }

}

class ThreadBinaryTree {
    private Node root;

    // 线索二叉树的前驱结点
    private Node pre = null;

    public void setRoot(Node root) {
        this.root = root;
    }
//中序线索化二叉树

    /**
     * 当前需要线索化的节点
     *
     * @param node
     */
    public void threadedNodes(Node node) {

        if (node == null) {
            return;
        }

        //向左
        threadedNodes(node.getLeftNext());

        //处理该节点
        //先判断LeftNext还有没有能往下指的了
        //没有能指的就先指向pre，因为pre为空
        if (node.getLeftNext() == null) {
            node.setLeftNext(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRightNext() == null) {
            pre.setRightNext(node);
            pre.setRightType(1);
        }

        //前驱结点开始有值，进行结点和pre的增替
        pre = node;


        //向右
        threadedNodes(node.getRightNext());

    }

    //遍历 中序 线索化二叉树
    public void threadedList() {
        Node node = root;

        while (node != null) {
            //根据中序的顺序 找到最下边leftType为1的节点
            while (node.getLeftType() == 0 ) {
                node = node.getLeftNext();
            }

            //打印找到的这个节点
            System.out.println(node);

            //如果找到的结点的RightType为1，则说明是线索化，就一直sout
            if (node.getRightType() == 1) {
                node = node.getRightNext();
                System.out.println(node);
            }

            //替换当前遍历的结点
            node = node.getRightNext();
        }

    }


    public void isEmpty() {
        if (root == null) {
            System.out.println("二叉树为空");
        }
    }

    //前序遍历
    public void preOrder() {
        isEmpty();
        root.preOrder();
    }

    //中序遍历
    public void midOrder() {
        isEmpty();
        root.midOrder();
    }

    //后序遍历
    public void postOrder() {
        isEmpty();
        root.postOrder();
    }

    //前序查找
    public Node preOrderSearch(Object e) {
        isEmpty();
        return root.preOrderSearch(e);
    }

    //中序查找
    public Node midOrderSearch(Object e) {
        isEmpty();
        return root.midOrderSearch(e);
    }

    //后序查找
    public Node postOrderSearch(Object e) {
        isEmpty();
        return root.postOrderSearch(e);
    }

    //删除节点
    public void delNode(Object data) {
        if (root == null) {
            System.out.println("空树");
        }

        if (root.getData() == data) {
            root = null;
        } else {
            root.delNode(data);
        }
    }

}

class Node {
    //二叉树里一般存储的数据形式是 key-value 的形式

    private Node leftNext;
    private Node rightNext;
    private Object data;

    /* 用type来区分 线索 和 非线索 的指向 */

    // leftType = 0 指向左子树 ， 如果是1则表示指向前驱结点
    private int leftType;
    // rightType = 0 指向右子树 ， 如果是1则表示指向后继结点
    private int rightType;

    public void setData(Object data) {
        this.data = data;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Node() {
    }

    public Node(Node leftNext, Node rightNext, Object data) {
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
    public void preOrder() {
        System.out.println(this);

        if (this.leftNext != null) {
            this.leftNext.preOrder();
        }

        if (this.rightNext != null) {
            this.rightNext.preOrder();
        }

    }

    //中序遍历
    public void midOrder() {

        if (this.leftNext != null) {
            this.leftNext.midOrder();
        }

        System.out.println(this);

        if (this.rightNext != null) {
            this.rightNext.midOrder();
        }

    }

    //后序遍历
    public void postOrder() {
        if (this.leftNext != null) {
            this.leftNext.postOrder();
        }


        if (this.rightNext != null) {
            this.rightNext.postOrder();
        }

        System.out.println(this);
    }

    //前序查找
    public Node preOrderSearch(Object e) {
        if (this.data == e) {
            return this;
        }

        Node resNode = null;
        if (this.leftNext != null) {
            resNode = this.leftNext.preOrderSearch(e);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.rightNext != null) {
            resNode = this.rightNext.preOrderSearch(e);
        }

        return resNode;
    }

    //中序查找
    public Node midOrderSearch(Object e) {

        Node resNode = null;
        if (this.leftNext != null) {
            resNode = this.leftNext.preOrderSearch(e);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.data == e) {
            return this;
        }

        if (this.rightNext != null) {
            resNode = this.rightNext.preOrderSearch(e);
        }

        return resNode;
    }

    //后序查找
    public Node postOrderSearch(Object e) {
        Node resNode = null;
        if (this.leftNext != null) {
            resNode = this.leftNext.preOrderSearch(e);
        }

        if (resNode != null) {
            return resNode;
        }


        if (this.rightNext != null) {
            resNode = this.rightNext.preOrderSearch(e);
        }

        if (this.data == e) {
            return this;
        }

        return resNode;
    }

    //节点的删除
    public void delNode(Object data) {

        //先看该节点的左子节点是否就是想要删除的
        if (this.leftNext != null && this.leftNext.data == data) {
            this.leftNext = null;
            return;
        }

        //然后看右节点
        if (this.rightNext != null && this.rightNext.data == data) {
            this.rightNext = null;
            return;
        }

        //对左子树进行递归删除
        if (this.leftNext != null) {
            this.leftNext.delNode(data);
        }

        if (this.rightNext != null) {
            this.rightNext.delNode(data);
        }



    }
}





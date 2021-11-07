package algorithm;


public class Joseph{


    public static void main(String[] args){
        //构造一个41个节点的循环链表
        NodeNode nodeNode41 = new NodeNode(null , 41);
        NodeNode nodeNode40 = new NodeNode(nodeNode41, 40);
        NodeNode nodeNode39 = new NodeNode(nodeNode40, 39);
        NodeNode nodeNode38 = new NodeNode(nodeNode39, 38);
        NodeNode nodeNode37 = new NodeNode(nodeNode38, 37);
        NodeNode nodeNode36 = new NodeNode(nodeNode37, 36);
        NodeNode nodeNode35 = new NodeNode(nodeNode36, 35);
        NodeNode nodeNode34 = new NodeNode(nodeNode35, 34);
        NodeNode nodeNode33 = new NodeNode(nodeNode34, 33);
        NodeNode nodeNode32 = new NodeNode(nodeNode33, 32);
        NodeNode nodeNode31 = new NodeNode(nodeNode32, 31);
        NodeNode nodeNode30 = new NodeNode(nodeNode31, 30);
        NodeNode nodeNode29 = new NodeNode(nodeNode30, 29);
        NodeNode nodeNode28 = new NodeNode(nodeNode29, 28);
        NodeNode nodeNode27 = new NodeNode(nodeNode28, 27);
        NodeNode nodeNode26 = new NodeNode(nodeNode27, 26);
        NodeNode nodeNode25 = new NodeNode(nodeNode26, 25);
        NodeNode nodeNode24 = new NodeNode(nodeNode25, 24);
        NodeNode nodeNode23 = new NodeNode(nodeNode24, 23);
        NodeNode nodeNode22 = new NodeNode(nodeNode23, 22);
        NodeNode nodeNode21 = new NodeNode(nodeNode22, 21);
        NodeNode nodeNode20 = new NodeNode(nodeNode21, 20);
        NodeNode nodeNode19 = new NodeNode(nodeNode20, 19);
        NodeNode nodeNode18 = new NodeNode(nodeNode19, 18);
        NodeNode nodeNode17 = new NodeNode(nodeNode18, 17);
        NodeNode nodeNode16 = new NodeNode(nodeNode17, 16);
        NodeNode nodeNode15 = new NodeNode(nodeNode16, 15);
        NodeNode nodeNode14 = new NodeNode(nodeNode15, 14);
        NodeNode nodeNode13 = new NodeNode(nodeNode14, 13);
        NodeNode nodeNode12 = new NodeNode(nodeNode13, 12);
        NodeNode nodeNode11 = new NodeNode(nodeNode12, 11);
        NodeNode nodeNode10 = new NodeNode(nodeNode11, 10);
        NodeNode nodeNode9 = new NodeNode(nodeNode10, 9);
        NodeNode nodeNode8 = new NodeNode(nodeNode9, 8);
        NodeNode nodeNode7 = new NodeNode(nodeNode8, 7);
        NodeNode nodeNode6 = new NodeNode(nodeNode7, 6);
        NodeNode nodeNode5 = new NodeNode(nodeNode6, 5);
        NodeNode nodeNode4 = new NodeNode(nodeNode5, 4);
        NodeNode nodeNode3 = new NodeNode(nodeNode4, 3);
        NodeNode nodeNode2 = new NodeNode(nodeNode3, 2);
        NodeNode nodeNode1 = new NodeNode(nodeNode2, 1);

        nodeNode41.next = nodeNode1;

        //计数器，每指到3就归零，并删除节点
        int count = 1;

        NodeNode preNodeNode = null;
        for(NodeNode temp = nodeNode1; temp != null ; temp = temp.next){
            if((count + 1 ) % 3 == 0){
                preNodeNode = temp;

            }

            if(count % 3 == 0){
                count = 0;
                preNodeNode.next = temp.next;
                System.out.println(temp);
            }

            if(temp.next == temp){
                break;
            }

            count++;
        }
    }

}

class NodeNode {
    public NodeNode next;
    public int num;

    public NodeNode(){

    }

    public NodeNode(NodeNode next , int num){
        this.next = next;
        this.num = num;
    }

    public String toString(){
        return num+"";
    }
}

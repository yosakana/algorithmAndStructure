package algorithm;

public class reverseLinkList {
    private static Node head;
    private static Node node1;
    private static Node node2;
    private static Node node3;
    private static Node node4;
    private static Node node5;


    public static void main(String[] args) {
        setList();
        //前指针 指向空
        Node cur = head;
        Node prev = null;
        Node temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        while(prev.next != null){
            System.out.println(prev);
            prev = prev.next;
        }
        System.out.println(prev);
    }

    public static void setList() {
        node5 = new Node("5", null);
        node4 = new Node("4", node5);
        node3 = new Node("3", node4);
        node2 = new Node("2", node3);
        node1 = new Node("1", node2);
        head = node1;
    }

}

class Node {

    public String data;
    public Node next;

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data;
    }
}

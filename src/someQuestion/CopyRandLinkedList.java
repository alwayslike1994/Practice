package someQuestion;

/**
 * 深拷贝带有分支的链表。额外空间复杂度0(1)。时间复杂度O(N)。
 */
public class CopyRandLinkedList {


    public static Node copyRandLinkedList(Node head) {
        Node cur = head;
        Node next = null;
        //合并
        while (cur != null) {
            next = cur.next;
            Node node1 = new Node(cur.value);
            cur.next = node1;
            node1.next = next;
            cur = next;
        }
        //整理链表
        cur = head;
        Node curCopy = null;
        while (cur != null) {
            curCopy = cur.next;
            curCopy.rand = cur.rand == null ? null : cur.rand.next;
            cur = cur.next.next;
        }
        //分开
        cur = head;

        Node res = head.next;
        curCopy = head.next;
        while (cur != null) {
            next = cur.next.next;
            cur.next = next;
            curCopy.next = next == null ? null : next.next;
            cur = next;
            curCopy = next == null ? null : cur.next;
        }
        return res;

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.rand = node3;
        node2.rand = node1;
        node3.rand = node4;
        Node nodeNew = copyRandLinkedList(node1);
        System.out.println(nodeNew);
    }
}

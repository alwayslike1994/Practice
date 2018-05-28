package someQuestion;

/**
 * 判断两个单链表是否有交点（两个都有环且环入口不同，两个都没环，两个都有环且入口相同）。时间复杂度O(N+M)。
 * 注意：一条有环一条没环一定不相交。
 */

public class FindFirstIntersectNode {
    public static Node findFirstIntersectNode(Node node1, Node node2) {
        Node loop1 = findLoop(node1);
        Node loop2 = findLoop(node2);
        if (loop1 != null && loop2 != null) {
            if (loop1 == loop2) {
                return getIntersectOutOfLoop(node1, node2, loop1, loop2);
            }
            return BothLoop(loop1, loop2);
        }
        if (loop1 == null && loop2 == null) {
            return noloop(node1, node2);
        }
        return null;
    }

    /**
     * 在圈外面是否有交点
     *
     * @param node1
     * @param node2
     * @param loop1
     * @param loop2
     * @return
     */
    public static Node getIntersectOutOfLoop(Node node1, Node node2, Node loop1, Node loop2) {
        int n = 0;
        Node cur1 = node1;
        Node cur2 = node2;
        while (cur1.next != loop1) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != loop2) {
            n--;
            cur2 = cur2.next;
        }
        int i = 0;
        cur1 = n > 0 ? node1 : node2;
        cur2 = cur1 == node1 ? node2 : node1;
        n = Math.abs(n);
        while (i < n) {
            cur1 = cur1.next;
            i++;

        }
        while (cur1 != loop1) {
            cur1 = cur1.next;
            cur2 = cur2.next;
            if (cur1 == cur2) {
                return cur1;
            }
        }
        return loop1;
    }

    /**
     * 两个无环的单链表是否有交点
     *
     * @param node1
     * @param node2
     * @return
     */
    public static Node noloop(Node node1, Node node2) {
        int n = 0;
        Node cur1 = node1;
        Node cur2 = node2;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        int i = 0;
        cur1 = n > 0 ? node1 : node2;
        cur2 = cur1 == node1 ? node2 : node1;
        n = Math.abs(n);
        while (i < n) {
            cur1 = cur1.next;
            i++;
        }
        while (cur1 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
            if (cur1 == cur2) {
                return cur1;
            }
        }
        return null;
    }

    /**
     * 两个都有环的单链表是否有交点
     *
     * @param loop1
     * @param loop2
     * @return
     */
    public static Node BothLoop(Node loop1, Node loop2) {

        Node cur = loop1.next;
        while (cur != loop1) {
            if (cur == loop2) {
                return loop1;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 单链表是否有环，并且返回环入口
     *
     * @param node
     * @return
     */
    public static Node findLoop(Node node) {
        Node node1 = node.next;
        Node node2 = node.next.next;
        while (node2 != null && node1 != node2) {
            node1 = node1.next;
            node2 = node2.next == null ? null : node2.next.next;
        }
        if (node2 == null) {
            return null;
        }
        node2 = node;
        while (node2 != node1) {

            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;

        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n7;
        Node p = findFirstIntersectNode(n1, n6);
        if (p != null) {
            System.out.println(p.value);
        } else {
            System.out.println("null");
        }
    }
}

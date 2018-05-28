package TreeQuestion;

/**
 * 中序前驱和后继节点的查找。O(h)，h为树的高度。
 */
public class FindProdromalSuccessor {
    /**
     * 得到中序后继节点
     *
     * @param node
     * @return
     */
    public static TreeNode findLDRSuccessorNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        while (node.parent != null && node != node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }

    /**
     * 得到中序前驱节点
     *
     * @param node
     * @return
     */
    public static TreeNode findLDRProdromalNode(TreeNode node) {
        if (node.left != null) {
            node = node.left;
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }
        while (node.parent != null && node.parent.right != node) {
            node = node.parent;
        }
        return node.parent;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.parent = n3.parent = n1;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.parent = n5.parent = n2;
        n6.parent = n7.parent = n3;
        System.out.println(findLDRSuccessorNode(n4).value);
        System.out.println(findLDRProdromalNode(n7).value);
    }
}

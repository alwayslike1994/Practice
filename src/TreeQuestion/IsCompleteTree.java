package TreeQuestion;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否为完全二叉树
 */
public class IsCompleteTree {
    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        boolean flag = true;//表示遇到了只有左孩子的没有右孩子的节点，表示以后的节点应该都是叶子节点才是完全二叉树。
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node.left == null && node.right != null) {
                return false;
            } else if (node.left != null && node.right != null) {
                if (!flag) return false;
                nodes.add(node.left);
                nodes.add(node.right);
            } else if (node.left != null) {
                flag = false;
                nodes.add(node.left);
            }
        }
        return true;
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
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
//        n6.right = n7;
        System.out.println(isCompleteTree(n1));
    }
}

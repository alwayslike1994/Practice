package TreeQuestion;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * 二叉树前中后序 递归非递归实现
 */
public class PrintTree {
    /**
     * 前序遍历 递归
     *
     * @param root
     */
    public static void printDLR1(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        printDLR1(root.left);
        printDLR1(root.right);
    }

    /**
     * 中序遍历 递归
     *
     * @param root
     */
    public static void printLDR1(TreeNode root) {
        if (root == null) {
            return;
        }
        printLDR1(root.left);
        System.out.print(root.value + " ");
        printLDR1(root.right);
    }

    /**
     * 后序遍历 递归
     *
     * @param root
     */
    public static void printLRD1(TreeNode root) {
        if (root == null) {
            return;
        }
        printLRD1(root.left);
        printLRD1(root.right);
        System.out.print(root.value + " ");
    }

    /**
     * 前序遍历 非递归自己用栈实现
     *
     * @param root
     */
    public static void printDLR2(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.empty()) {
            TreeNode node = nodes.pop();
            System.out.print(node.value + " ");
            if (node.right != null) {
                nodes.push(node.right);
            }
            if (node.left != null) {
                nodes.push(node.left);
            }
        }
    }

    /**
     * 中序遍历 非递归
     *
     * @param root
     */
    public static void printLDR2(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        while (!nodes.empty() || root != null) {
            if (root != null) {
                nodes.push(root);
                root = root.left;
            } else {
                root = nodes.pop();
                System.out.print(root.value + " ");
                root = root.right;
            }
        }
    }

    /**
     * 后序遍历 非递归
     * 结合前序遍历（中左右）改成（中右左），再结合一个栈实现（左右中）。
     *
     * @param root
     */
    public static void printLRD2(TreeNode root) {
        Stack<TreeNode> nodes1 = new Stack<>();
        Stack<TreeNode> nodes2 = new Stack<>();
        nodes1.push(root);
        while (!nodes1.empty()) {
            TreeNode node = nodes1.pop();
            nodes2.push(node);
            if (node.left != null) {
                nodes1.push(node.left);
            }
            if (node.right != null) {
                nodes1.push(node.right);
            }
        }
        while (!nodes2.empty()) {
            System.out.print(nodes2.pop().value + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;
        n4.left = n6;
        n4.right = n7;
        n5.left = n8;
        n5.right = n9;
        n9.left = n10;
        printDLR1(n1);
        System.out.println("======================");
        printDLR2(n1);
        System.out.println("======================");
        printLRD1(n1);
        System.out.println("======================");
        printLRD2(n1);
        System.out.println("======================");
        printLDR1(n1);
        System.out.println("======================");
        printLDR2(n1);
        System.out.println("======================");
    }
}

package javacode.tree;

import java.util.Stack;

public class PostOrderBinaryTree {
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.val = 1;

        Node node1Left = new Node();
        node1Left.val = 2;

        Node node1Right = new Node();
        node1Right.val = 3;

        Node node2Right = new Node();
        node2Right.val = 4;

        node1Right.right = node2Right;

        node1.left = node1Left;
        node1.right = node1Right;

        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        Node t = node1;
        //stack.push(t);

        int rightCount = 0;
        int leftCount = 0;

        stack.push(t);
        while (!stack.isEmpty()) {
            Node q = stack.pop();

            stack2.push(q);

            if (q.left != null) {
                stack.push(q.left);
            }

            if (q.right != null) {
                stack.push(q.right);
            }
        }

        while (!stack2.isEmpty()) {
            Node q = stack2.pop();
            System.out.println("Post Order: " + q.val);
        }



    }
}

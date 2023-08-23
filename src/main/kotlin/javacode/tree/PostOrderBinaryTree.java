package javacode.tree;

import java.util.Stack;

public class PostOrderBinaryTree {
    public static void main(String[] args) {
        Node node1 = new Node();
        node1.data = 1;

        Node node1Left = new Node();
        node1Left.data = 2;

        Node node1Right = new Node();
        node1Right.data = 3;

        Node node2Right = new Node();
        node2Right.data = 4;

        node1Right.rightNode = node2Right;

        node1.leftNode = node1Left;
        node1.rightNode = node1Right;

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

            if (q.leftNode != null) {
                stack.push(q.leftNode);
            }

            if (q.rightNode != null) {
                stack.push(q.rightNode);
            }
        }

        while (!stack2.isEmpty()) {
            Node q = stack2.pop();
            System.out.println("Post Order: " + q.data);
        }



    }
}

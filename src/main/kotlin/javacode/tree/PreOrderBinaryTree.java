package javacode.tree;

import java.util.Stack;

public class PreOrderBinaryTree {
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

        Node t = node1;
        //stack.push(t);

        int rightCount = 0;
        int leftCount = 0;
        while (t != null || !stack.isEmpty()) {
            if (t != null) {
                leftCount += 1;
                System.out.println(t.val);
                stack.push(t);
                t = t.left;
            } else {
                rightCount += 1;
                t = stack.pop();
                t = t.right;
            }
        }

        System.out.println("Right: " + rightCount + " Left: " + leftCount);

    }
}

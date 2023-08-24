package javacode.tree;

import java.util.Stack;

public class InOrderBinaryTree {

    public static Node getTree() {
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

        return node1;

    }

    public static void main(String[] args) {
        Node head = getTree();

        Stack<Node> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.val);
                head = head.right;
            }

        }

    }
}

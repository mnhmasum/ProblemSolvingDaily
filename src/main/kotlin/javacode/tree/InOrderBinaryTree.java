package javacode.tree;

import java.util.Stack;

public class InOrderBinaryTree {

    public static Node getTree() {
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

        return node1;

    }

    public static void main(String[] args) {
        Node head = getTree();

        Stack<Node> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.leftNode;
            } else {
                head = stack.pop();
                System.out.println(head.data);
                head = head.rightNode;
            }

        }

    }
}

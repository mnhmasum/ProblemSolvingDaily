package javacode.tree;

import java.sql.SQLOutput;
import java.util.Stack;

public class CreateBinaryTree {
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

        Node t = node1;
        //stack.push(t);

        int rightCount = 0;
        int leftCount = 0;
        while (t != null || !stack.isEmpty()) {
            if (t != null) {
                leftCount += 1;
                System.out.println(t.data);
                stack.push(t);
                t = t.leftNode;
            } else {
                rightCount += 1;
                t = stack.pop();
                t = t.rightNode;
            }
        }

        System.out.println("Right: " + rightCount + " Left: " + leftCount);

    }
}

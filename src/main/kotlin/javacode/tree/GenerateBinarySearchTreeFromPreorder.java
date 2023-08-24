package javacode.tree;

import java.util.Stack;

public class GenerateBinarySearchTreeFromPreorder {
    public static void main(String[] args) {
        //int[] preorderList = {15, 13, 12, 18};
        int[] preorderList = {30, 20, 10, 15, 25, 40, 50, 45};

        Stack<Node> stack = new Stack<>();
        Node root = new Node(preorderList[0]);
        Node currentNode = root;

        for (int i = 1; i < preorderList.length; i++) {

            int item = preorderList[i];
            Node newNode = new Node(item);

            if (item > currentNode.val) {
                while (item > currentNode.val && !stack.isEmpty() && item > stack.peek().val) {
                    currentNode = stack.pop();
                }
                currentNode.right = newNode;

            } else {
                currentNode.left = newNode;
                stack.push(currentNode);
            }
            currentNode = newNode;
        }


        //InOrder Section to Test is it working or not

        Stack<Node> stack1 = new Stack<>();
        while (root != null || !stack1.isEmpty()) {
            if (root != null) {
                stack1.push(root);
                root = root.left;
            } else {
                root = stack1.pop();
                System.out.println(root.val);
                root = root.right;
            }

        }


    }
}

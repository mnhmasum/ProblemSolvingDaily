package javacode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s){
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.toCharArray()[i];
            System.out.println(c);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.values().contains(c)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String string="(){[]{}()()()}";
        System.out.println(isValid(string));
    }
}

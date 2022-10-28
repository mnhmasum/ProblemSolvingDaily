package javacode;

import java.util.ArrayList;

public class FindDuplicateCharacter {
    public static void main(String[] args) {
        int counter = 0;
        String[] words = {"cool", "lock", "cook"};
        System.out.println(words);
        char[] toBeFound = words[0].toCharArray();
        ArrayList<String> result = new ArrayList<String>();
        for (char c : toBeFound) {
            for (int j = 0; j < words.length; j++) {
                String s = words[j];
                if (s.contains(Character.toString(c))) {
                    counter++;
                }

                if (counter == 3) {
                    result.add("" + c);
                    for (int i = 0; i < words.length; i++) {
                        words[i] = words[i].replaceFirst("" + c, "");
                    }

                    System.out.println(words);
                }
            }

            counter = 0;

        }

        System.out.println(result.toString());

    }
}

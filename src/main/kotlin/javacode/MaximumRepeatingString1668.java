package javacode;

public class MaximumRepeatingString1668 {
    public static int maxRepeating(String sequence, String word) {
        int c=0;
        String add=word;
        while(sequence.contains(word)==true)
        {
            c+=1;
            word=word+add;
            System.out.println(word);
        }
        return c;
    }
    public static void main(String[] args) {
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
}

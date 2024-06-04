package javacode;

public class SortingSentence1859 {

    public static String sortSentence(String s) {
        String[] x = s.split(" ");
        String[] words = new String[x.length];

        for (int i = 0; i < x.length; i++) {
            char lastChar = x[i].charAt(x[i].length() - 1);
            words[lastChar - 49] = x[i].substring(0, x[i].length() - 1);
            System.out.println(lastChar);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(words[i]);
        }

        return words.toString();

    }

    public static boolean areNumbersAscending(String s) {
        int prevNumber = 0;
        String words[] = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            if(Character.isDigit(words[i].charAt(0))) {
                int currentNumber = Integer.parseInt(words[i]);
                if(prevNumber >= currentNumber) {
                    return false;
                } else {
                    prevNumber = currentNumber;
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(sortSentence("Myself2 Me1 I4 and3"));

        System.out.println(areNumbersAscending("2 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }
}

package javacode;

public class FindValueOfVariableAfterPerformingOperations {
    public static int finalValueAfterOperations(String[] operations) {
        int result = 0;

        for (String operation: operations) {
            if(operation.equalsIgnoreCase("--X") || operation.equalsIgnoreCase("X--")) {
                result -= 1;
            } else {
                result += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] operations = {"X++","++X","--X","X--"};
        System.out.println(finalValueAfterOperations(operations));
    }
}

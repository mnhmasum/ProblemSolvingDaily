package javacode.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Long> nnn = new ArrayList<>(Arrays.asList(12L, 3L));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3));

        NumericalOperation<Long> numberList = new NumericalOperation<>(nnn);
        new NumericalOperation<>(list2);
    }
}

package javacode.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberType<T extends Number & Comparable<T>> {
    public List<T> listOfNumber;

    public NumberType(List<T> list) {
        this.listOfNumber = new ArrayList<>(list);
    }

    public List<T> getSortedItems() {
        Collections.sort(listOfNumber);
        return listOfNumber;
    }

    public T getMaxNumber() {
        return Collections.max(listOfNumber);
    }

}

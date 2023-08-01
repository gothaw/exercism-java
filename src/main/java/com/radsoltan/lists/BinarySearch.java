package com.radsoltan.lists;

import com.radsoltan.exc.ValueNotFoundException;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> {
    private final List<T> list;
    private int index = 0;

    public BinarySearch(List<T> list) {
        this.list = list;
    }

    private int search(T a, List<T> list) throws ValueNotFoundException {
        if (list.isEmpty()) {
            throw new ValueNotFoundException("Value not in array");
        }
        int splitIndex = (int) (0.5 * list.size());
        T middle = list.get(splitIndex);
        List<T> left = list.subList(0, splitIndex);
        List<T> right = list.subList(splitIndex, list.size());

        if (a.compareTo(middle) == 0) {
            return index + splitIndex;
        } else if (splitIndex == 0) {
            throw new ValueNotFoundException("Value not in array");
        } else if (a.compareTo(middle) < 0) {
            return this.search(a, left);
        } else {
            index += splitIndex;
            return this.search(a, right);
        }
    }

    public int indexOf(T a) throws ValueNotFoundException {
        return this.search(a, list);
    }
}

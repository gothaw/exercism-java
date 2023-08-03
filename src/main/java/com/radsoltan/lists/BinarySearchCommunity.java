package com.radsoltan.lists;

import com.radsoltan.exc.ValueNotFoundException;

import java.util.List;

public class BinarySearchCommunity {
    private final List<Integer> list;

    public BinarySearchCommunity(List<Integer> list) {
        this.list = list;
    }

    public int indexOf(int target) throws ValueNotFoundException {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int middle = (right - left) / 2 + left;
            int middleValue = list.get(middle);

            if (middleValue == target)
                return middle;
            else if (target > middleValue)
                left = middle + 1;
            else
                right = middle - 1;

        }

        throw new ValueNotFoundException("Value not in array");
    }
}

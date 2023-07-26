package com.radsoltan.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flattener {
    public List<?> flatten(List<?> list) {
        List<Object> flattenList = new ArrayList<>();

        list.stream()
                .filter(Objects::nonNull)
                .forEach(object -> {
                    if (object instanceof List) {
                        flattenList.addAll(flatten((List<?>) object));
                    } else {
                        flattenList.add(object);
                    }
                });

        return flattenList;
    }
}

package com.radsoltan.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class FlattenerCommunity {
    public List<?> flatten(List<?> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .flatMap(object -> object instanceof List
                        ? flatten((List<?>) object).stream()
                        : Stream.of(object))
                .toList();
    }
}

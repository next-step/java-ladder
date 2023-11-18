package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.Name;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Names {

    private static final String COMMA_SPLIT_REGEX = ",";
    private static final int MINIMUM_PEOPLE = 2;

    private final List<Name> values;

    public static Names from(String names) {
        List<Name> collect = Arrays.stream(names.split(COMMA_SPLIT_REGEX))
                                   .map(Name::new)
                                   .collect(toUnmodifiableList());
        return new Names(collect);
    }

    public Names(List<Name> values) {
        validateAtLeastTwo(values.size());
        this.values = values;
    }

    private void validateAtLeastTwo(int size) {
        if (size < MINIMUM_PEOPLE) {
            throw new IllegalArgumentException("사다리 게임은 최소 2명이 필요합니다.");
        }
    }

    public int size() {
        return this.values.size();
    }

    public String getNames(String format) {
        return this.values.stream()
                          .map(Name::getName)
                          .map(name -> String.format(format, name))
                          .reduce("", (previous, newOne) -> previous + newOne);
    }
}

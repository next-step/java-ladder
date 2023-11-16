package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.Name;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

public class Names {

    private final List<Name> values;

    public static Names from(String names) {
        List<Name> collect = Arrays.stream(names.split(","))
                                   .map(Name::new)
                                   .collect(toUnmodifiableList());
        return new Names(collect);
    }

    public Names(List<Name> values) {
        validateAtLeastTwo(values);
        this.values = values;
    }

    private void validateAtLeastTwo(List<Name> values) {
        if (values.size() < 2) {
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

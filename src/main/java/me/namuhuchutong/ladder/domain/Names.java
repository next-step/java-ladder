package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.Name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Names {

    private static final String COMMA_SPLIT_REGEX = ",";
    private static final int MINIMUM_SIZE = 2;

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
        if (size < MINIMUM_SIZE) {
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

    public Stream<Name> stream() {
        return this.values.stream();
    }

    public int getSequence(Name name) {
        validateContains(name);
        return this.values.indexOf(name);
    }

    private void validateContains(Name name) {
        if (!this.values.contains(name)) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
    }

    public Name getNthName(Integer index) {
        validateIndex(index);
        return this.values.get(index);
    }

    private void validateIndex(Integer index) {
        if(index < 0 || isBiggerThanSize(index)) {
            throw new IllegalArgumentException("인덱스가 이름 수의 범위를 벗어났습니다. - " + index);
        }
    }

    private boolean isBiggerThanSize(Integer index) {
        return this.values.size() - 1 < index;
    }

    public boolean contains(String inputStringName) {
        Name name = new Name(inputStringName);
        return this.values.contains(name);
    }
}

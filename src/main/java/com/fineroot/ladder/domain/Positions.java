package com.fineroot.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Positions {
    private final List<Position> value;

    private Positions(List<Position> value) {
        this.value = value;
    }

    public static Positions from(List<Position> value) {
        return new Positions(value);
    }

    public static Positions fromIntArray(Integer... values) {
        return new Positions(Arrays
                .stream(values)
                .map(Position::new)
                .collect(Collectors.toList()));
    }

    public String matchString(final Function<Position, String> rewardString, final int userIndex){
        return rewardString.apply(value.get(userIndex));
    }

    public String matchAllString(final Function<Position, String> userString,
                                 final Function<Position, String> rewardString) {
        return IntStream.range(0, value.size())
                .boxed()
                .map(toIntegerStringFunction(userString, rewardString))
                .collect(Collectors.joining())
                .stripTrailing();
    }

    private Function<Integer, String> toIntegerStringFunction(Function<Position, String> userString,
                                                               Function<Position, String> rewardString) {
        return e -> userString.
                apply(new Position(e)).concat(" : ").concat(rewardString.apply(value.get(e)))
                .concat(System.lineSeparator());
    }
}

package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum Step {
    EMPTY,
    EXIST;

    public static List<Step> initialize(int size) {
        return IntStream.range(0, size).mapToObj(unused -> Step.EMPTY).collect(Collectors.toList());
    }

    public boolean exist() {
        return this == EXIST;
    }
}

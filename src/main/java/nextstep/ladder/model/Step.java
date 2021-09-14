package nextstep.ladder.model;

import java.util.stream.IntStream;

public enum Step {
    EMPTY,
    EXIST;

    public static Step[] initialize(int size) {
        return IntStream.range(0, size).mapToObj(unused -> Step.EMPTY).toArray(Step[]::new);
    }

    public boolean exist() {
        return this == EXIST;
    }
}

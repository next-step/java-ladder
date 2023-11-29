package nextstep.ladder.domain;

import java.util.function.Function;

public enum Direction {

    LEFT(point -> point - 1),
    CENTER(point -> point),
    RIGHT(point -> point + 1);

    private final Function<Integer, Integer> nextPoint;

    Direction(Function<Integer, Integer> nextPoint) {
        this.nextPoint = nextPoint;
    }

    public int nextPoint(int point) {
        return this.nextPoint.apply(point);
    }
}

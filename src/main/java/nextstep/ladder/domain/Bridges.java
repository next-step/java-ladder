package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Ladder.*;
import static nextstep.ladder.exception.ExceptionMessage.*;

public class Bridges {

    public static final String TRUE_BRIDGE = "-----";
    public static final String FALSE_BRIDGE = "     ";
    private static final int[] DIRECTIONS = {0 , -1};
    public static final int DEPTH_ADJUSTMENT = 1;

    private final List<Boolean> bridges;

    public Bridges(List<Boolean> bridges) {
        if (existStraight(bridges)) {
            throw new IllegalArgumentException(NOT_TRUE_STRAIGHT.message());
        }

        this.bridges = bridges;
    }

    private boolean existStraight(List<Boolean> bridges) {
        return IntStream.range(0, bridges.size() - 1)
            .anyMatch(i -> bridges.get(i) && bridges.get(i + 1));
    }

    public int move(int currentPosition) {
        return Arrays.stream(DIRECTIONS)
            .filter(direction -> isMovable(currentPosition + direction))
            .map(direction -> movableSide(direction, currentPosition + direction))
            .findAny()
            .orElse(currentPosition);
    }

    private int movableSide(int direction, int next) {
        if (direction == DIRECTIONS[0]) {
            return next + DEPTH_ADJUSTMENT;
        }

        return next;
    }

    public boolean isMovable(int nextCoordinate) {
        if (isOutOfRange(nextCoordinate)) {
            return false;
        }

        return bridges.get(nextCoordinate);
    }

    private boolean isOutOfRange(int nextCoordinate) {
        return nextCoordinate < 0 || nextCoordinate >= bridges.size();
    }

    @Override
    public String toString() {
        return bridges.stream()
            .map(bridge -> bridge ? TRUE_BRIDGE : FALSE_BRIDGE)
            .collect(Collectors.joining(LADDER_POLE));
    }
}

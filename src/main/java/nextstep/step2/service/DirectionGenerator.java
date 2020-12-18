package nextstep.step2.service;

import nextstep.step2.VO.Direction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Predicate;

public class DirectionGenerator {

    public static Direction getFirstDirection() {
        return getDirection(firstDirectionFilter());
    }

    public static Direction getNextDirection(Direction previous) {
        return getDirection(nextDirectionFilter(previous));
    }

    public static Direction getLasDirection() {
        return getDirection(firstDirectionFilter());
    }

    private static int defineDirectionWay() {
        return new Random().nextInt(3);
    }

    private static Direction getDirection(Predicate<Direction> filterCondition) {
        return Arrays.stream(Direction.values())
                .filter(filterCondition)
                .min(Comparator.comparingInt(direction -> defineDirectionWay()))
                .get();
    }

    private static Predicate<Direction> firstDirectionFilter() {
        return direction -> direction != Direction.LEFT;
    }

    private static Predicate<Direction> nextDirectionFilter(Direction previous) {
        if (previous == Direction.RIGHT) {
            return direction -> direction == Direction.LEFT;
        }

        return direction -> direction != Direction.LEFT;
    }

    private static Predicate<Direction> lastDirectionFilter(Direction previous) {
        if (previous == Direction.RIGHT) {
            return direction -> direction == Direction.LEFT;
        }

        return direction -> direction == Direction.DOWN;
    }
}

package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.utils.LineUtil.getLastDirection;

public final class Line {

    private static final int MIDDLE_MINUS_COUNT = 2;

    private final List<Direction> directions;

    private Line(final List<Direction> directions) {
        this.directions = directions;
    }

    public static Line generate(final DirectionStrategy directionStrategy, final int userCount) {
        List<Direction> directions = new ArrayList<>();
        directions.add(generateFirstDirection(directionStrategy));
        directions.addAll(generateMiddleDirections(directionStrategy, userCount, directions));
        directions.add(generateLastDirection(directions));

        return new Line(directions);
    }

    private static Direction generateFirstDirection(DirectionStrategy directionStrategy) {
        return Direction.ofFirst(directionStrategy);
    }

    private static List<Direction> generateMiddleDirections(DirectionStrategy directionStrategy,
                                                            int userCount,
                                                            List<Direction> directions) {
        return IntStream.range(0, userCount - MIDDLE_MINUS_COUNT)
                .mapToObj(ignore -> generateMiddleDirection(directionStrategy, directions))
                .collect(Collectors.toList());
    }

    private static Direction generateMiddleDirection(DirectionStrategy directionStrategy, List<Direction> directions) {
        return getLastDirection(directions).ofNext(directionStrategy);
    }

    private static Direction generateLastDirection(List<Direction> directions) {
        return getLastDirection(directions).ofLast();
    }

    public List<Direction> getDirections() {
        return directions;
    }
}

package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class Line {

    private static final int MIDDLE_MINUS_COUNT = 2;

    private final List<Direction> directions;

    private Line(final DirectionStrategy directionStrategy, final int userCount) {
        directions = new ArrayList<>();
        initDirections(directionStrategy, userCount);
    }

    public static Line generate(final DirectionStrategy directionStrategy, final int userCount) {
        return new Line(directionStrategy, userCount);
    }

    private void initDirections(DirectionStrategy directionStrategy, int userCount) {
        addFirstDirection(directionStrategy);
        addMiddleDirections(directionStrategy, userCount - MIDDLE_MINUS_COUNT);
        addLastDirection();
    }

    private void addFirstDirection(final DirectionStrategy directionStrategy) {
        directions.add(Direction.ofFirst(directionStrategy));
    }

    private void addMiddleDirections(final DirectionStrategy directionStrategy, final int userCount) {
        IntStream.range(0, userCount)
                .mapToObj(ignore -> getLastDirection().ofNext(directionStrategy))
                .forEach(directions::add);
    }

    private void addLastDirection() {
        directions.add(getLastDirection().ofLast());
    }

    private Direction getLastDirection() {
        return directions.get(directions.size() - 1);
    }

    public List<Direction> getDirections() {
        return directions;
    }
}

package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class Line {

    private final List<Direction> directions;

    public Line(final DirectionStrategy directionStrategy, final int userCount) {
        directions = new ArrayList<>();
        directions.add(Direction.ofFirst(directionStrategy));
        IntStream.range(1, userCount - 1)
                .mapToObj(ignore -> getLastDirection().ofNext(directionStrategy))
                .forEach(directions::add);
        directions.add(getLastDirection().ofLast());
    }

    private Direction getLastDirection() {
        return directions.get(directions.size() - 1);
    }

    public List<Direction> getDirections() {
        return directions;
    }
}

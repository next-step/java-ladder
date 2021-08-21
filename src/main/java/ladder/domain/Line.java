package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Direction> directions;

    public Line(DirectionStrategy directionStrategy, int userCount) {
        directions = new ArrayList<>();
        directions.add(Direction.first(directionStrategy));
        IntStream.range(1, userCount - 1)
                .mapToObj(ignore -> getLastDirection().next(directionStrategy))
                .forEach(directions::add);
        directions.add(getLastDirection().last());
    }

    private Direction getLastDirection() {
        return directions.get(directions.size() - 1);
    }

    public List<Direction> getDirections() {
        return directions;
    }
}

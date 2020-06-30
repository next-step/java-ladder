package nextstep.ladder.domain.ladders;

import nextstep.ladder.common.Direction;
import nextstep.ladder.domain.result.Point;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MIN_WIDTH = 2;
    private final List<Direction> directions;

    public Line(int width, LineCreateStrategy lineCreateStrategy) {
        validateWidth(width);

        List<Direction> directions = new ArrayList<>();
        directions.add(lineCreateStrategy.first());
        for (int i = MIN_WIDTH; i < width; i++) {
            directions.add(lineCreateStrategy.body(directions.get(directions.size() - 1)));
        }
        directions.add(lineCreateStrategy.last(directions.get(directions.size() - 1)));
        validateDirection(directions);

        this.directions = directions;
    }

    private void validateWidth(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException("width is must more than " + MIN_WIDTH);
        }
    }

    private void validateDirection(List<Direction> directions) {
        if (directions.get(0) == Direction.LEFT) {
            throw new IllegalDirectionException("first cannot be connected to left");
        }

        if (directions.get(directions.size() - 1) == Direction.RIGHT) {
            throw new IllegalDirectionException("last cannot be connected to right");
        }

        directions.stream()
                .filter(d -> d != Direction.CENTER)
                .reduce((d1, d2) -> {
                    if (d1 == d2) {
                        throw new IllegalDirectionException("Directions cannot be connected in series");
                    }
                    return d2;
                });
    }

    public void move(Point point) {
        Direction direction = directions.get(point.getIndex());
        point.move(direction);
    }

    public List<Direction> getDirections() {
        return directions;
    }
}

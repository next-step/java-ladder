package nextstep.ladder.domain.tobe;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MIN_WIDTH = 2;
    private final List<Direction> directions;

    public Line(int width, LineCreateStrategy lineCreateStrategy) {
        validateWidth(width);

        directions = new ArrayList<>();
        directions.add(lineCreateStrategy.first());
        for (int i = MIN_WIDTH; i < width; i++) {
            directions.add(lineCreateStrategy.body());
        }
        directions.add(lineCreateStrategy.last());
    }

    private void validateWidth(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException("width is must more than " + MIN_WIDTH);
        }
    }

    public List<Direction> getDirections() {
        return directions;
    }
}

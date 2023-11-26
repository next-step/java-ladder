package nextstep.ladder.domain;

import nextstep.ladder.exception.LineDuplicateException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Direction.LEFT;

public class Line {
    private final List<Direction> directions;

    public Line(List<Direction> directions) {
        validateDirectionsContinuity(directions);
        this.directions = new ArrayList<>(directions);
    }

    private void validateDirectionsContinuity(List<Direction> directions) {
        IntStream.range(0, directions.size() - 1)
                .filter(index -> LEFT == directions.get(index) && LEFT == directions.get(index + 1))
                .findFirst()
                .ifPresent(i -> {
                    throw new LineDuplicateException();
                });
    }

    public int size() {
        return directions.size();
    }

    public List<Direction> directions() {
        return Collections.unmodifiableList(directions);
    }
}

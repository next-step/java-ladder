package nextstep.ladder.domain;

import nextstep.ladder.exception.LineDuplicateException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.domain.Direction.LEFT;

public class Line {
    private final List<Direction> directions;

    public Line(int[] directions) {
        this(Arrays.stream(directions)
                .mapToObj(Direction::of)
                .collect(Collectors.toList())
        );
    }

    public Line(Direction direction) {
        this(List.of(direction));
    }

    public Line(List<Direction> directions) {
        validateDirectionsContinuity(directions);
        this.directions = new ArrayList<>(directions);
    }

    private void validateDirectionsContinuity(List<Direction> directions) {
        IntStream.range(0, directions.size() - 1)
                .filter(index -> isDuplicateLeftDirection(directions, index))
                .findFirst()
                .ifPresent(i -> {
                    throw new LineDuplicateException();
                });
    }

    private boolean isDuplicateLeftDirection(List<Direction> directions, int index) {
        return LEFT == directions.get(index) && LEFT == directions.get(index + 1);
    }

    public Direction move(int position) {
        return directions.get(position);
    }

    public int size() {
        return directions.size();
    }

    public List<Direction> directions() {
        return Collections.unmodifiableList(directions);
    }


}

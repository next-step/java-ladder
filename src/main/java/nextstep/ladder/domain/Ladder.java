package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.Direction.STAY;

public class Ladder {

    private static final int SINGLE_PERSON = 1;

    private final List<Line> lines;

    public Ladder(DirectionStrategy directionStrategy, Height height, int countOfPerson) {
        this.lines = Stream.generate(() -> createLine(directionStrategy, countOfPerson))
                .limit(height.height())
                .collect(Collectors.toList());
    }

    private static Line createLine(DirectionStrategy directionStrategy, int countOfPerson) {
        if (countOfPerson == SINGLE_PERSON) {
            return new Line(STAY);
        }
        return new Line(directionStrategy, countOfPerson);
    }

    public int climb(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

}

package ladder.domain;

import ladder.exception.LineListNullPointerException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Ladder {

    public static final int START_INCLUSIVE = 0;

    private final List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static final Ladder from(List<Line> ladder) {
        validateNull(ladder);
        return new Ladder(ladder);
    }

    private static final void validateNull(List<Line> ladder) {
        if (Objects.isNull(ladder)) {
            throw new LineListNullPointerException();
        }
    }

    public static final Ladder from(People people, LadderHeight height) {
        return from(IntStream.range(START_INCLUSIVE, height.toInt())
                .mapToObj(i -> Line.of(people.countOfPerson()))
                .collect(Collectors.toList())
        );
    }
}

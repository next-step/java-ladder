package ladder.domain;

import ladder.exception.LineListNullPointerException;
import ladder.strategy.LineGenerateStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Ladder {

    private static final int START_INCLUSIVE = 0;

    private final List<Line> ladder;

    public static final Ladder from(List<Line> ladder) {
        return new Ladder(ladder);
    }

    public static final Ladder from(People people, LadderHeight height, LineGenerateStrategy strategy) {
        return from(IntStream.range(START_INCLUSIVE, height.toInt())
                .mapToObj(i -> Line.of(people.countOfPerson(), strategy))
                .collect(Collectors.toList())
        );
    }

    public Ladder(List<Line> ladder) {
        validateNull(ladder);
        this.ladder = ladder;
    }

    private final void validateNull(List<Line> ladder) {
        if (Objects.isNull(ladder)) {
            throw new LineListNullPointerException();
        }
    }

    public final Stream<Line> stream() {
        return ladder.stream();
    }
}

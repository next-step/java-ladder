package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Ladder {

    private final List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static final Ladder from(List<Line> ladder) {
        return new Ladder(ladder);
    }

    public static final Ladder from(People people, int height) {
        return from(IntStream.range(0, height)
                .mapToObj(i -> Line.of(people.countOfPerson()))
                .collect(Collectors.toList())
        );
    }
}

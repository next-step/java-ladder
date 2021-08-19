package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;

    private Ladder(int countOfPerson, int height) {
        ladder = IntStream.range(0, height)
            .mapToObj(index -> Line.from(countOfPerson))
            .collect(Collectors.toList());
    }

    public static Ladder from(int countOfPerson, int height) {
        return new Ladder(countOfPerson, height);
    }

    public List<Line> toList() {
        return ladder;
    }
}

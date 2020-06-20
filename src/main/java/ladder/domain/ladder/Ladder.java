package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    public static final int LEAST_HEIGHT = 0;

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfPerson, int ladderHeight, LineStrategy lineStrategy) {
        validate(ladderHeight);
        return Stream.generate(() -> Line.of(countOfPerson, lineStrategy))
                .limit(ladderHeight)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }

    private static void validate(int ladderHeight) {
        if (ladderHeight < LEAST_HEIGHT) {
            throw new IllegalArgumentException("Ladder height must be positive.");
        }
    }

    public Line get(int index) {
        return lines.get(index);
    }

    public int height() {
        return lines.size();
    }
}

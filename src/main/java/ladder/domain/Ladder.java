package ladder.domain;

import ladder.exception.LadderHeightException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private static final int LADDER_MIN_HEIGHT = 2;

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    private Ladder(int countOfPerson, int height) {
        validate(height);
        ladder = Collections.unmodifiableList(
            Stream.generate(() -> Line.from(countOfPerson))
                .limit(height)
                .collect(Collectors.toList())
        );
    }

    public static Ladder from(List<Line> ladder) {
        return new Ladder(ladder);
    }

    public static Ladder from(int countOfPerson, int height) {
        return new Ladder(countOfPerson, height);
    }

    private void validate(int height) {
        if (height < LADDER_MIN_HEIGHT) {
            throw new LadderHeightException(LADDER_MIN_HEIGHT);
        }
    }

    public int resultIndexOf(Index index) {
        ladder.stream().forEach(index::moveOf);
        return index.val();
    }

    public List<Line> toList() {
        return ladder;
    }
}

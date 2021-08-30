package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.exception.LadderHeightException;
import ladder.strategy.MovableStrategy;

public class Ladder {
    private static final int LADDER_MIN_HEIGHT = 2;

    private final List<LadderLine> ladder;

    private Ladder(List<LadderLine> ladder) {
        this.ladder = ladder;
    }

    private Ladder(int countOfPerson, int height, MovableStrategy movableStrategy) {
        validate(height);
        ladder = Collections.unmodifiableList(
            Stream.generate(() -> LadderLine.init(countOfPerson, movableStrategy))
                .limit(height)
                .collect(Collectors.toList())
        );
    }

    public static Ladder from(List<LadderLine> ladder) {
        return new Ladder(ladder);
    }

    public static Ladder from(int countOfPerson, int height, MovableStrategy movableStrategy) {
        return new Ladder(countOfPerson, height, movableStrategy);
    }

    private void validate(int height) {
        if (height < LADDER_MIN_HEIGHT) {
            throw new LadderHeightException(LADDER_MIN_HEIGHT);
        }
    }

    public int resultIndexOf(Index index) {
        ladder.forEach(index::moveOf);
        return index.val();
    }

    public List<LadderLine> toList() {
        return ladder;
    }
}

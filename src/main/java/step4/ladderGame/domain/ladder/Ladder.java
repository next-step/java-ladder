package step4.ladderGame.domain.ladder;

import step4.ladderGame.domain.exception.CountOfPlayerOutOfBoundsException;
import step4.ladderGame.domain.exception.HeightLowException;
import step4.ladderGame.domain.ladder.GenerateDirectionStrategy.GenerateDirectionStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Ladder {

    private static final int MIN_COUNT_BY_USER = 2;
    private static final int MIN_HEIGHT = 1;

    private final List<LadderLine> ladderLines;
    private final Height height;

    public Ladder(final int playerCount, final int height, final GenerateDirectionStrategy generateDirectionStrategy) {
        validate(playerCount, height);

        this.height = Height.valueOf(height);
        ladderLines = IntStream.range(0, height)
                .mapToObj(index -> LadderLine.init(playerCount, generateDirectionStrategy))
                .collect(Collectors.toList());
    }

    public static Ladder of(final int playerCount, final int height, final GenerateDirectionStrategy generateDirectionStrategy) {
        validate(playerCount, height);
        return new Ladder(playerCount, height, generateDirectionStrategy);
    }

    private static void validate(final int countOfUser, final int height) {
        if (countOfUser < MIN_COUNT_BY_USER) {
            throw new CountOfPlayerOutOfBoundsException();
        }
        if (height < MIN_HEIGHT) {
            throw new HeightLowException();
        }
    }

    public int move(int position) {
        for (int i = 0; i < height.getValue(); i++) {
            position = ladderLines.get(i).move(position);
        }

        return position;
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    public Stream<LadderLine> stream() {
        return ladderLines.stream();
    }

}

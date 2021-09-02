package step4.ladderGame.domain.ladder;

import step4.ladderGame.domain.exception.CountOfPlayerOutOfBoundsException;
import step4.ladderGame.domain.exception.HeightLowException;
import step4.ladderGame.domain.ladder.pointGenerationStrategy.LadderLineRandomGenerationStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Ladder {

    private static final int MIN_COUNT_BY_USER = 2;
    private static final int MIN_HEIGHT = 1;

    private final List<Line> lines;
    private final Height height;

    public Ladder(final int playerCount, final int height) {
        validate(playerCount, height);

        this.height = new Height(height);
        lines = IntStream.range(0, height)
                .mapToObj(index -> new Line(playerCount, new LadderLineRandomGenerationStrategy()))
                .collect(Collectors.toList());
    }

    private void validate(final int countOfUser, final int height) {
        if (countOfUser < MIN_COUNT_BY_USER) {
            throw new CountOfPlayerOutOfBoundsException();
        }
        if (height < MIN_HEIGHT) {
            throw new HeightLowException();
        }
    }

    public int move(int playerIndex) {
        for (int i = 0; i < height.getValue(); i++) {
            playerIndex = lines.get(i).move(playerIndex);
        }

        return playerIndex;
    }

    public List<Line> getLines() {
        return lines;
    }

}

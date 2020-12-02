package step2.domain;

import step2.exception.LadderHeightException;
import step2.exception.ValidPlayerCountException;
import step2.hint.LadderLine;
import step2.hint.LadderPointGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.unmodifiableList;

public class Ladder{
    public static final int MIN_LADDER_HEIGHT = 1;
    public static final int MIN_PLAYER_COUNT = 1;
    private final List<LadderLine> lines;

    private Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder of(final int ladderHeight, final int playerCount , final LadderPointGenerator ladderPointGenerator) {
        validLineHeight(ladderHeight);
        validPlayerCount(playerCount);

        return new Ladder(
                IntStream.range(0, ladderHeight)
                        .mapToObj(i -> LadderLine.init(playerCount , ladderPointGenerator))
                        .collect(Collectors.toList()));
    }


    public int moveAll(int startPosition) {
        int currentPosition = startPosition;
        for (LadderLine line : lines) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }

    public List<LadderLine> getLines() {
        return unmodifiableList(lines);
    }

    private static void validPlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT) {
            throw new ValidPlayerCountException();
        }
    }

    private static void validLineHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new LadderHeightException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}

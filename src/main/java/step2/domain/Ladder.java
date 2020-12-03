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

public class Ladder {
    public static final int MIN_LADDER_HEIGHT = 1;
    public static final int MIN_PLAYER_COUNT = 1;
    private final List<LadderLine> lines;

    private Ladder(LadderBuilder builder) {
        validLineHeight(builder.ladderHeight);
        validPlayerCount(builder.playerCount);

        lines = IntStream.range(0, builder.ladderHeight)
                .mapToObj(i -> LadderLine.init(builder.playerCount, builder.ladderPointGenerator))
                .collect(Collectors.toList());
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


    public static class LadderBuilder {

        private int ladderHeight;
        private int playerCount;
        private LadderPointGenerator ladderPointGenerator;

        public LadderBuilder buildLadderHeight(int ladderHeight) {
            this.ladderHeight = ladderHeight;
            return this;
        }

        public LadderBuilder buildPlayerCount(int playerCount) {
            this.playerCount = playerCount;
            return this;
        }

        public LadderBuilder buildLadderPointGenerator(LadderPointGenerator ladderPointGenerator) {
            this.ladderPointGenerator = ladderPointGenerator;
            return this;
        }

        public Ladder build() {
            return new Ladder(this);
        }
    }
}

package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;
    private final int playerCount;

    public Ladder(List<LadderLine> ladderLines, int playerCount) {
        this.ladderLines = Collections.unmodifiableList(ladderLines);
        this.playerCount = playerCount;
    }

    public LadderResults exec() {
        return new LadderResults(IntStream.range(0, playerCount)
                .mapToObj(Position::new)
                .collect(Collectors.toMap(Function.identity(), this::getResultPosition)));
    }

    private Position getResultPosition(Position startPosition) {
        Position currentPosition = startPosition;
        for (LadderLine ladderLine : ladderLines) {
            currentPosition = ladderLine.move(currentPosition);
        }
        return currentPosition;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder)) return false;
        Ladder ladder = (Ladder) o;
        return playerCount == ladder.playerCount &&
                Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines, playerCount);
    }
}

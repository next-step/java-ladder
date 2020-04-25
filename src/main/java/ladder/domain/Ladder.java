package ladder.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public static Ladder of(LadderLineInfo ladderLineInfo, int height) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i -> LadderLine.from(ladderLineInfo))
                .collect(Collectors.toList()));
    }

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = Collections.unmodifiableList(new ArrayList<>(ladderLines));
    }

    public Map<Position, Position> exec(int playerCount) {
        return IntStream.range(0, playerCount)
                .mapToObj(Position::new)
                .collect(Collectors.toMap(Function.identity(), this::getResultPosition));
    }

    private Position getResultPosition(Position startPosition) {
        Position currentPosition = startPosition;
        for (LadderLine ladderLine : ladderLines) {
            currentPosition = ladderLine.move(currentPosition);
        }
        return currentPosition;
    }

    public List<LadderLine> getLadderLines() {
        return new ArrayList<>(ladderLines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder)) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}

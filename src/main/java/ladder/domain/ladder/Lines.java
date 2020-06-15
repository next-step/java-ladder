package ladder.domain.ladder;

import ladder.domain.ladder.ladderInfo.LineCount;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {

    private final List<Line> lines;
    private int playerCount;

    public Lines(final List<Line> lines, int playerCount){
        validate(lines);
        this.lines = lines;
        this.playerCount = playerCount;
    }

    public LadderResults create() {
        return new LadderResults(Stream.iterate(0, i -> i < playerCount, i -> i + 1)
                .map(Position::new)
                .collect(Collectors.toMap(Function.identity(), this::getResultPosition)));
    }

    public Position getResultPosition(Position startPosition) {
        Position currentPosition = startPosition;
        for (Line line : lines) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }

    public List<Line> getLineList() {
        return Collections.unmodifiableList(lines);
    }

    private static void validate(List<Line> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("lines 의 값이 null 입니다.");
        }
    }
}

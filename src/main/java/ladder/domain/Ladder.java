package ladder.domain;

import ladder.controller.LadderSize;
import ladder.strategy.PathStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private static final int HEIGHT_MIN = 2;
    private final List<Line> lines;

    private Ladder(long width, long height, PathStrategy pathStrategy) {
        validateHeight(height);
        this.lines = generateLadder(width, height, pathStrategy);
    }

    private void validateHeight(long height) {
        if (height < HEIGHT_MIN) {
            throw new IllegalArgumentException("최소 높이는 2개 이상입니다.");
        }
    }

    public static Ladder of(LadderSize ladderSize, PathStrategy pathStrategy) {
        return new Ladder(ladderSize.width(), ladderSize.height(), pathStrategy);
    }

    public static Ladder of(long width, long height, PathStrategy pathStrategy) {
        return new Ladder(width, height, pathStrategy);
    }

    private List<Line> generateLadder(long width, long height, PathStrategy pathStrategy) {
        return Stream.generate(() -> Line.of(width, pathStrategy))
                .limit(height)
                .collect(Collectors.toList());
    }

    public List<Line> ladder() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(lines, ladder1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : lines) {
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }
}

package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder of(int ladderMaxLength, int countOfPerson, NextStrategy nextStrategy) {
        return getLadder(ladderMaxLength, countOfPerson, nextStrategy);
    }

    private static Ladder getLadder(int ladderMaxLength, int countOfPerson, NextStrategy nextStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderMaxLength; i++) {
            lines.add(Line.of(countOfPerson, nextStrategy));
        }

        return new Ladder(lines);
    }

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int getLadderWidth() {
        return lines.stream()
                .map(Line::getSize)
                .findFirst()
                .orElse(0);
    }

    public int getLadderHeight() {
        return lines.size();
    }

    public int movedPosition(int position) {
        int result = position;

        for (Line line : lines) {
            int currentPosition = result;
            result = line.movedPosition(currentPosition);
        }

        return result;
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

    public boolean isDraw(int row, int column) {
        return lines.get(row).isDraw(column);
    }
}

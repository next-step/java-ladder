package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    private Ladder(int ladderMaxLength, int countOfPerson) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < ladderMaxLength; i++) {
            this.lines.add(Line.of(countOfPerson));
        }
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder of(int ladderMaxLength, int countOfPerson) {
        return new Ladder(ladderMaxLength, countOfPerson);
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

    public boolean havePoints(int row, int column) {
        Line currentLine = lines.get(row);
        return currentLine.havePoints(column);
    }

    public int move(int position) {
        int result = position;

        for (Line line : lines) {
            int currentPosition = result;
            result = line.move(currentPosition);
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
}

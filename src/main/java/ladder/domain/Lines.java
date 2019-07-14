package ladder.domain;

import java.util.*;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {

        this.lines = lines;
    }

    public int move(int startPosition) {

        if (startPosition < 0 || startPosition >= maxWidth()) {
            throw new IllegalArgumentException("시작 위치가 유효하지 않습니다.");
        }

        int position = startPosition;
        for (Line line : lines) {
            position = line.move(position);
        }

        return position;
    }

    private int maxWidth() {

        return lines.size() - 1;
    }

    public List<Line> getLines() {

        return Collections.unmodifiableList(lines);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lines);
    }
}

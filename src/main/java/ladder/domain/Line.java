package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> line;

    public Line(List<Boolean> line) {
        this.line = line;
    }

    public Line addedLine(boolean point) {
        ArrayList<Boolean> newLine = new ArrayList<>(line);
        newLine.add(point);
        return new Line(newLine);
    }

    public boolean isLastTrue() {
        if (line.size() == 0) {
            throw new IndexOutOfBoundsException("line에 값이 없습니다.");
        }
        return line.get(line.size() - 1);
    }

    public boolean isLeftEdge(int index) {
        return index > -1;
    }

    public boolean isRightEdge(int index) {
        return index < line.size();
    }

    public boolean isRoadExist(int index) {
        return line.get(index);
    }

    public List<Boolean> line() {
        return line;
    }

    @Override
    public String toString() {
        return line.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return line.equals(line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}

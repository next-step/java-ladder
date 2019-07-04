package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> line;


    public Line(int size, LineStrategy strategy) {
        line = new ArrayList<>(size);

        for(int i = 0 ; i < size ; i++) {
            line.add(strategy.putPoint(i));
        }
    }

    public Line(List<Boolean> list) {
        if (list.get(list.size()-1)) {
            throw new IllegalArgumentException();
        }

        line = list;
    }

    public List<Boolean> getLine() {
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line1 = (Line) o;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

    public int move(int point) {
        if (line.get(point)) {
            return point + 1;
        }

        if (point == 0) {
            return point;
        }

        if (line.get(point-1)) {
            return point - 1;
        }

        return point;
    }
}

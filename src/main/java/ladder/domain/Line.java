package ladder.domain;

import java.util.ArrayList;
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
}

package nextstep.ladder;

import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Cross> crosses;

    public Line(int countOfVerticalLine, LineStrategy lineStrategy) {
        this.crosses = lineStrategy.generate(countOfVerticalLine);
    }

    public List<Cross> getCrosses() {
        return crosses;
    }

    public int move(int verticalLine) {
        Cross cross = crosses.get(verticalLine);
        return cross.move(verticalLine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(crosses, line.crosses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crosses);
    }
}

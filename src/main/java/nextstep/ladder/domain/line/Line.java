package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.generator.LineGenerator;

import java.util.List;
import java.util.Objects;

public class Line {

    private static final int MIN_WIDTH = 0;
    private final List<Boolean> line;

    public Line (LineGenerator lineGenerator, int countOfPerson) {
        line = lineGenerator.generator(countOfPerson);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.line.getClass() != o.getClass()) return false;
        return Objects.equals(line, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }

    public boolean hasLine(int width) {
        if (width >= this.line.size()) {
            return false;
        }
        return this.line.get(width);
    }

    public boolean isNotEnd(int position) {
        return position >= MIN_WIDTH && position < this.line.size();
    }

    public boolean isLefEnd(int position) {
        return position == MIN_WIDTH;
    }

    public boolean isRightEnd(int position) {
        return position >= this.line.size();
    }
}

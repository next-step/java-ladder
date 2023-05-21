package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.generator.LineGenerator;

import java.util.List;
import java.util.Objects;

public class Line {

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
        return this.line.get(width);
    }
}

package rick.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import rick.strategy.PointCreationStrategy;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int ladderLineCount, PointCreationStrategy pointCreationStrategy) {
        IntStream.range(0, ladderLineCount)
            .mapToObj(idx-> new Line(countOfPerson, pointCreationStrategy))
            .forEach(lines::add);
    }

    public Ladder(List<Line> lines) {
        this.lines.addAll(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}

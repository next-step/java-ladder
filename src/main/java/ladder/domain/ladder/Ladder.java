package ladder.domain.ladder;

import ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Ladder {

    private final List<Line> lines;
    private final LadderComponent component;

    private Ladder(List<Line> lines, LadderComponent component) {
        this.lines = new ArrayList<>(lines);
        this.component = component;
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Ladder createLadder(LineStrategy strategy, LadderComponent component) {
        List<Line> lines = range(0, component.getHeight())
                .mapToObj(range -> Line.createLine(component.getWidth(), strategy))
                .collect(toList());
        return new Ladder(lines, component);
    }

    public int move(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
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

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }

}





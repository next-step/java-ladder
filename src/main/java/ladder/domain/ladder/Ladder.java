package ladder.domain.ladder;

import ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Ladder createLadder(LineStrategy strategy, LadderComponentDto component) {
        List<Line> lines = range(0, component.getHeight())
                .mapToObj(range -> Line.createLine(component.getPlayers().size(), strategy))
                .collect(toList());
        return new Ladder(lines);
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





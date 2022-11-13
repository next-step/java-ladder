package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public Stream<Line> stream() {
        return lines.stream();
    }

    public int arriveAt(int start) {
        Axis axis = new Axis(0, start);
        for (Line line : lines) {
            Direction direction = line.get(axis.getCol());
            axis = axis.add(direction);
        }
        return axis.getCol();
    }
}

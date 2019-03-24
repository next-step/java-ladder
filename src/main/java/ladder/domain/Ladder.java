package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines;

    public Ladder() {
        this.lines = new ArrayList<>();
    }

    public int generate(int low, int column) {
        IntStream.range(0, low)
            .mapToObj(i -> new Line(column))
            .forEach(line -> this.lines.add(line));

        return low;
    }

    public List<Line> getLines() {
        return lines;
    }
}

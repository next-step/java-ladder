package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder() {
        this.lines = new ArrayList<>();
    }

    public int generate(int low, int column) {
        IntStream.range(0, low)
            .mapToObj(i -> Line.generate(column))
            .forEach(this.lines::add);

        return low;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}

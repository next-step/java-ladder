package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generate(LadderSize ladderSize, ConnectionStrategy connectionStrategy) {
        List<Line> lines = IntStream.range(0, ladderSize.height())
                .mapToObj(i -> Line.generate(ladderSize.width(), connectionStrategy))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public int size() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int move(int i) {
        return 0;
    }
}

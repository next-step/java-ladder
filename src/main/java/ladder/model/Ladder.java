package ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfUser, int ladderSize) {
        List<Line> lines = IntStream.range(0, ladderSize)
                .mapToObj(size -> Line.of(countOfUser, new RandomLineGenerator()))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public int size() {
        return this.lines.size();
    }
}

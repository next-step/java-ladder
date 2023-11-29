package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(int count) {
        return new Ladder(
            IntStream.range(0, count)
                .mapToObj(i -> Line.from(3))
                .collect(Collectors.toList()));
    }

    public int ladderSize() {
        return lines.size();
    }
}

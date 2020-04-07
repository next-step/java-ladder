package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(int candidatesCount, int height) {
        this.lines = Collections.unmodifiableList(
                IntStream.range(0, height)
                        .mapToObj(i -> Line.ofCandidateCount(candidatesCount))
                        .collect(Collectors.toList())
        );
    }

    public static Ladder of(int candidatesCount, int height) {
        return new Ladder(candidatesCount, height);
    }

    public List<Line> getLines() {
        return lines;
    }

}

package ladder.domain.ladder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int size) {
        return Optional.of(height)
                .filter(h -> h > 0)
                .map(h -> makeLadder(h,size))
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Create Ladder failed. height must be over 0: height=%d", height)));
    }

    private static Ladder makeLadder(int height, int size) {
        return new Ladder(Stream.iterate(
                LineMaker.makeLine(size), line -> LineMaker.makeLine(size))
                .limit(height)
                .collect(Collectors.toList()));
    }

    public List<Line> getLines() {
        return lines;
    }
}

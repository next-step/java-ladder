package ladder.domain.ladder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Ladder failed. height must be at least %d: height=%d";
    private static final int MINIMUM_HEIGHT = 1;
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int size) {
        return Optional.of(height)
                .filter(h -> h >= MINIMUM_HEIGHT)
                .map(h -> makeLadder(h, size))
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format(INSTANTIATE_ERROR_FORMAT, MINIMUM_HEIGHT, height)));
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

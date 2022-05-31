package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Row> rows;

    public Ladder(int height, int width) {
        this.rows = Stream.generate(() -> Row.createRandom(width))
                .limit(height - 1)
                .collect(Collectors.toList());
    }
}

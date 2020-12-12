package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;
    private final List<Row> rows;

    private Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder of(int width, int height, LinkStrategy strategy) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("height must be greater than " + MINIMUM_HEIGHT + " or equal");
        }
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i -> Row.of(width, strategy))
                .collect(Collectors.toList())
        );
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }

    public List<Integer> getResult() {
        final List<Integer> initialPosition = IntStream.rangeClosed(0, rows.get(0).getLinks().size())
                .boxed()
                .collect(Collectors.toList());
        return rows.stream()
                .reduce(initialPosition, (pos, row) -> row.step(pos), (pos1, pos2) -> pos2);
    }
}

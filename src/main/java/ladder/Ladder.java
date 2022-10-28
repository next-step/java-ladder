package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Row> rows;

    private Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder of(int people, int height) {
        RowGenerator rowGenerator = new RowGenerator();

        List<Row> rows = IntStream.range(0, height)
            .mapToObj(i -> rowGenerator.create(people))
            .collect(Collectors.toList());

        return new Ladder(rows);
    }

    public List<Row> getLadderLines() {
        return rows;
    }
}

package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "rows=" + rows +
                '}';
    }

    public Ladder(int height, int width) {
        this.rows = Stream.generate(() -> Row.createRandom(width))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int result(int index) {
        for (Row row:this.rows ) {
            index = row.move(index); // Q: okay to overwrite parameter?
        }
        return index;
    }

    public int height() {
        return this.rows.size();
    }

    public String toShow() {
        return this.rows
                .stream()
                .map(row -> row.toShow())
                .reduce("", (acc, cur) -> acc + cur);
    }
}

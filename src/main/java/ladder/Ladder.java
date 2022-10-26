package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Row> rows;
    private Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder of(int countOfPerson, int height) {
        List<Row> rows = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Row row = Row.from(countOfPerson);
            Row generate = row.generate(countOfPerson);
            rows.add(generate);
        }

        return new Ladder(rows);
    }

    public List<Row> getLadderLines() {
        return rows;
    }
}

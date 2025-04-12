package nextstep.ladder.game;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder create(int width, int height) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rows.add(Row.create(width));
        }
        return new Ladder(rows);
    }

    public List<Row> getRows() {
        return rows;
    }
}

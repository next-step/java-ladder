package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rows {
    private static List<Row> rows;

    private Rows(List<Row> rows) {
        this.rows = Collections.unmodifiableList(rows);
    }

    public static Rows create(int playerCount, Height height) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            rows.add(Row.create(playerCount));
        }
        return new Rows(rows);
    }

    public List<Row> getRows() {
        return rows;
    }

    public int getSize() {
        return rows.size();
    }

    public Row getRowsElement(int index) {
        return rows.get(index);
    }
}
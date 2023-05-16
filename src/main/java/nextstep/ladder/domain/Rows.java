package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rows {
    List<Row> rows;

    public Rows(List<Row> rows) {
        this.rows = rows;
    }

    public static Rows of(int usersCount, int height, PointGenerator generator) {
        List<Row> rows = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            rows.add(Row.of(generator, usersCount));
        }
        return new Rows(rows);
    }

    public int getResultX(int x) {
        for (int i = 0; i < rows.size(); i++) {
            x = rows.get(i).getNextX(x);
        }
        return x;
    }

    public List<Row> getPoints() {
        return Collections.unmodifiableList(rows);
    }
}

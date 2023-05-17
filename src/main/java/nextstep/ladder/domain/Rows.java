package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rows {
    List<Row> lines;

    public Rows(List<Row> lines) {
        this.lines = lines;
    }

    public static Rows of(int usersCount, int height, PointGenerator generator) {
        List<Row> lines = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            lines.add(Row.of(generator, usersCount));
        }
        return new Rows(lines);
    }

    public List<Row> getPoints() {
        return Collections.unmodifiableList(lines);
    }
}

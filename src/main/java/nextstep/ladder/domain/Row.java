package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Row {
    List<Point> row;

    public Row(List<Point> row) {
        this.row = row;
    }

    public static Row of(PointGenerator generator, int usersCount) {
        List<Point> row = new ArrayList<>();
        for (int x = 0; x < usersCount; x++) {
            row.add(generator.generate(existLeft(row, x), x));
        }
        return new Row(row);
    }

    public static boolean existLeft(List<Point> row, int x) {
        boolean movableLeft = false;
        if (x != 0) {
            movableLeft = row.get(x - 1).movableRight();
        }
        return movableLeft;
    }

    public List<Point> getRow() {
        return Collections.unmodifiableList(row);
    }


}

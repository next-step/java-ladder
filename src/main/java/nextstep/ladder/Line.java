package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    Line(int playerCount, Random random) {
        this.points = new ArrayList<>();

        for (int i = 0; i < playerCount - 1; i++) {
            if (i == 0) {
                points.add(random.nextBoolean());
                continue;
            }

            if (points.get(i - 1) == true) {
                points.add(false);
                continue;
            }

            points.add(random.nextBoolean());
        }
    }

    Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int calculateNextPosition(int cursor) {
        if (cursor == 0 && points.get(cursor)) {
            return ++cursor;
        }

        if (cursor == points.size() && points.get(cursor - 1)) {
            return --cursor;
        }

        if (points.get(cursor - 1)) {
            return --cursor;
        }

        if (points.get(cursor)) {
            return ++cursor;
        }

        return cursor;

    }
}

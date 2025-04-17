package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    public Line(int playerCount, Random random) {
        this.points = new ArrayList<>();

        for (int i = 0; i < playerCount - 1; i++) {
            if (i == 0) {
                points.add(random.nextBoolean());
            } else if (points.get(i - 1) == true) {
                points.add(false);
            } else {
                points.add(random.nextBoolean());
            }
        }
    }

    Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int calculateNextPosition(int cursor) {
        if (cursor == 0) {
            if (points.get(cursor)) {
                cursor++;
            }
        } else if (cursor == points.size()) {
            if (points.get(cursor - 1)) {
                cursor--;
            }
        } else {
            if (points.get(cursor - 1)) {
                cursor--;
            } else if (points.get(cursor)) {
                cursor++;
            }
        }

        return cursor;
    }
}

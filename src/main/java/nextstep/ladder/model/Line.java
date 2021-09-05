package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int height) {
        for (int i = 0; i < height; i++) {
            points.add(new Point());
        }
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int moveHorizontal(int x, int y) {
        Point point = points.get(y);

        if (point.isUsed()) {
            return point.getGoal();
        }

        return x;
    }
}

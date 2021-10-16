package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            points.add(new Point());
        }
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int getPointsSize() {
        return points.size();
    }
}

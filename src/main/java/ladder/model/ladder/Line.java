package ladder.model.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(int countOfPlayers) {
        int numberOfPoints = countOfPlayers - 1;
        this.points = initializePoints(numberOfPoints);
    }

    private List<Point> initializePoints(int numberOfPoints) {
        boolean previousHasLine = false;
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < numberOfPoints; i++) {
            Point point = Point.create(previousHasLine);
            points.add(point);
            previousHasLine = point.hasLine();
        }
        return Collections.unmodifiableList(points);
    }

    public List<Point> getPoints() {
        return points;
    }
}

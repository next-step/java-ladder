package ladder;

import ladder.util.CustomRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(int numberOfParticipant) {
        for (int i = 0; i < numberOfParticipant; i++) {
            points.add(new Point(CustomRandom::nextBoolean));
        }
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int getPointsSize() {
        return points.size();
    }
}

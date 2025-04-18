package ladder.domain;

import ladder.service.PointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line (int countOfPerson, PointGenerator pointGenerator) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(pointGenerator.generate(i, points));
        }
        validate();
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
    }

    int getNextIndex(int index) {
        if (index < points.size() && points.get(index).isConnected()) {
            return index + 1;
        }
        if (index > 0 && points.get(index - 1).isConnected()) {
            return index - 1;
        }
        return index;
    }

    private void validate() {
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).isConnected() && points.get(i + 1).isConnected()) {
                throw new IllegalArgumentException("Two consecutive points cannot be connected.");
            }
        }
    }
}

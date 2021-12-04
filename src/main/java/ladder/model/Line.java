package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points = new ArrayList<Point>();

    public Line (int countOfPerson) {
        initPoints(countOfPerson);
    }

    public List<String> draw() {
        return points.stream()
                .map(point -> point.draw())
                .collect(Collectors.toList());
    }

    private void initPoints(int countOfPerson) {
        points.add(Point.first());
        for(int idx = 1; idx < countOfPerson; idx++) {
            points.add(points.get(idx-1).next());
        }
    }
}
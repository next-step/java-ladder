package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(int personCount, BarCreator barCreator) {

        points.add(Point.first(barCreator));

        for (int i = 1; i < personCount - 1; i++) {
            points.add(Point.next(prevPointDirection(i), barCreator));
        }

        int lastIndex = personCount - 1;
        points.add(Point.last(prevPointDirection(lastIndex)));
    }

    public Direction prevPointDirection(int index) {
        return points.get(index - 1).getDirection();
    }

    public List<String> lineToString() {
        return points.stream()
                     .map(Point::toString)
                     .collect(Collectors.toList());
    }

    public int move(int currentIndex) {
        return currentIndex + points.get(currentIndex).move();
    }
}

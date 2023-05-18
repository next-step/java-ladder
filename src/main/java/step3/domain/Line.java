package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final int FIRST_LAST_INDEX = 2;
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line createLine(int countOfPlayers, MoveStrategy moveStrategy) {
        List<Point> playersPoint = new ArrayList<>();
        Point point = Point.first(moveStrategy.move());
        playersPoint.add(point);
        for (int idx = 0; idx < countOfPlayers - FIRST_LAST_INDEX; idx++) {
            point = point.next();
            playersPoint.add(point);
        }
        playersPoint.add(point.last());

        return new Line(playersPoint);
    }

    public int size(){
        return points.size();
    }
    public List<Point> getPoints() {
        return points;
    }

    public List<Boolean> getCurrent() {
        return points.stream().map(Point::getCurrent).collect(Collectors.toList());
    }

}

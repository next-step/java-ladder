package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> pointsNew;

    public Line(List<Point> pointsNew) {
        this.pointsNew = pointsNew;
    }

    public Line(int playersCount) {
        this.pointsNew = init(playersCount);
    }

    private List<Point> init(int playersCount) {
        List<Point> pointsNew = new ArrayList<>();

        PointGenerator pointGenerator = new PointGenerator(pointsNew);
        Point point = pointGenerator.first();
        Point lastBodyPoint = pointGenerator.body(playersCount - 2, point);
        pointGenerator.last(lastBodyPoint);

        return pointsNew;
    }

    public int move(int positionIndex) {
        return pointsNew.get(positionIndex).move();
    }

    @Override
    public String toString() {
        return "Line{" +
                "pointsNew=" + pointsNew +
                '}';
    }
}

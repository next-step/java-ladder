package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<PointNew> pointsNew;

    public Line(List<PointNew> pointsNew) {
        this.pointsNew = pointsNew;
    }

    public Line(int playersCount) {
        this.pointsNew = init(playersCount);
    }

    private List<PointNew> init(int playersCount) {
        List<PointNew> pointsNew = new ArrayList<>();

        PointGenerator pointGenerator = new PointGenerator(pointsNew);
        PointNew pointNew = pointGenerator.first();
        PointNew lastBodyPoint = pointGenerator.body(playersCount - 2, pointNew);
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

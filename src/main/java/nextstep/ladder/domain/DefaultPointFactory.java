package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultPointFactory implements PointFactory{
    private Random random = new Random();
    @Override
    public List<Point> createPoints(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(false));

        for (int i = 1; i < countOfPerson; i++) {
            addPoint(points, i);
        }

        return points;
    }

    private void addPoint(List<Point> points, int index) {
        if (leftPoint(points, index).isMovable()){
            points.add(new Point(false));
            return;
        }

        points.add(new Point(random.nextBoolean()));
    }

    private Point leftPoint(List<Point> points, int index) {
        return points.get(index - 1);
    }
}

package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class PointsFactory {

    public static List<Point> generate(int countOfPoints, PointGenerator trueOfFalse) {
        List<Point> points = new ArrayList<>();
        while (points.size() < countOfPoints) {
            addPoint(points, trueOfFalse.get());
        }
        return points;
    }

    private static void addPoint(List<Point> points, Point newPoint) {
        if (canAdd(points, newPoint)) {
            points.add(newPoint);
        }
    }

    private static boolean canAdd(List<Point> points, Point newPoint) {
        return points.isEmpty() || !points.get(points.size() - 1).checkConnected(newPoint);
    }
}

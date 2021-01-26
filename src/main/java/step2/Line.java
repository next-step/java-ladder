package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line newLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();

        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(validPrePoint(RandomGeneratorPoint.generatorRandomPoint(), points));
        }

        return new Line(points);
    }

    private static boolean validPrePoint(boolean point, List<Boolean> points) {
        if (point && points.size() > 0 && points.get(points.size() - 1)) {
            return false;
        }

        return point;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int size() {
        return points.size();
    }
}

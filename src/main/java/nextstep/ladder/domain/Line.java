package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public boolean hasLeftPoint(int currentPlayerPoint) {
        if (currentPlayerPoint == 0) {
            return false;
        }
        return points.get(currentPlayerPoint - 1);
    }

    public boolean hasRightPoint(int currentPlayerPoint) {
        if (points.size() == currentPlayerPoint || points.size() < currentPlayerPoint) {
            return false;
        }
        return points.get(currentPlayerPoint);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public static List<Boolean> generatePoints(Supplier<Boolean> pointSupplier, int count) {
        List<Boolean> points = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            addPoint(points, index, pointSupplier.get());
        }
        return points;
    }

    private static void addPoint(List<Boolean> points, int index, boolean point) {
        if (index == 0 || !points.get(index - 1)) {
            points.add(point);
            return;
        }
        points.add(false);
    }

}

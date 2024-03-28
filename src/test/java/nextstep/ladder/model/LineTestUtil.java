package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LineTestUtil {
    public static Line createLineBy(Boolean... points) {
        return new Line(convertToPoints(List.of(points)));
    }

    private static List<Point> convertToPoints(List<Boolean> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("인자가 비어있습니다");
        }

        List<Point> result = new ArrayList<>();
        result.add(Point.first(points.get(0)));

        for (int i = 1; i <= points.size() - 1; i++) {
            Point before = result.get(i - 1);
            boolean right = points.get(i);
            result.add(before.next(right));
        }

        Point beforeLast = result.get(result.size() - 1);
        result.add(beforeLast.last());

        return result;
    }
}

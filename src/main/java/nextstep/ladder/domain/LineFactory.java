package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public final class LineFactory {

    private LineFactory() {
    }

    public static Line createLine(final int length) {
        final List<Point> points = new ArrayList<>();
        Point point = null;
        for (int i = 0; i < length; i++) {
            point = PointFactory.create(point, i, length);
            points.add(point);
        }
        return Line.from(points);
    }
}

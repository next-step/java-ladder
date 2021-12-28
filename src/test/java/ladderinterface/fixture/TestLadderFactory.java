package ladderinterface.fixture;


import ladderinterface.concrete.LadderLine;
import ladderinterface.concrete.Point;
import ladderinterface.engine.Line;

import java.util.ArrayList;
import java.util.List;


public class TestLadderFactory {

    public static Line createLine(boolean...current) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(current[0]);
        points.add(point);
        for (int i = 1; i < current.length - 1; i++) {
            point = point.next(current[i]);
            points.add(point);
        }
        points.add(point.last());
        return LadderLine.of(points);
    }

}

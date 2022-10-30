package ladder.utils;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;

public class LadderUtils {

    public static Ladder createLadder() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(true));
        points.add(new Point(false));
        points.add(new Point(true));

        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(false));
        points2.add(new Point(true));
        points2.add(new Point(false));

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(points));
        lines.add(new Line(points2));
        lines.add(new Line(points));
        lines.add(new Line(points2));
        lines.add(new Line(points));

        return new Ladder(lines);
    }

}

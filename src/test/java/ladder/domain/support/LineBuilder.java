package ladder.domain.support;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.ladder.RandomLineGenerator;

import java.util.ArrayList;
import java.util.List;

public class LineBuilder {

    protected static List<Line> createRandomLinesBuild(int height, int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new RandomLineGenerator().generateLine(width));
        }
        return lines;
    }

    protected static Line createRandomLineBuild(int width) {
        return new RandomLineGenerator().generateLine(width);
    }

    protected static Line createFixedLineBuild() {
        Point first = Point.first(true);
        Point second = first.next(false);
        Point third = second.next(false);
        Point fourth = third.last(true);

        ArrayList<Point> points = new ArrayList<>();

        points.add(first);
        points.add(second);
        points.add(third);
        points.add(fourth);

        return new Line(points);
    }

}

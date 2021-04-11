package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestLadder {

    private TestLadder() {}

    /*
     *  create Ladder like
     *     |-----|     |-----|
     *     |     |-----|     |
     *     |-----|     |     |
     *     |     |-----|     |
     *     |-----|     |-----|
     */
    public static Ladder ladder() {
        return new Ladder(lines());
    }

    private static List<Line> lines() {
        List<Point> points1 = fourPoints();
        List<Point> points2 = fourPoints();
        List<Point> points3 = fourPoints();
        List<Point> points4 = fourPoints();
        List<Point> points5 = fourPoints();

        connectPoints(points1, 0, 1);
        connectPoints(points1, 2, 3);

        connectPoints(points2, 1, 2);

        connectPoints(points3, 0, 1);

        connectPoints(points4, 1, 2);

        connectPoints(points5, 0, 1);
        connectPoints(points5, 2, 3);

        return Stream.of(points1, points2, points3, points4, points5)
                     .map(Line::new)
                     .collect(Collectors.toList());
    }

    private static List<Point> fourPoints() {
        return LineTest.separatedPoints(4);
    }

    private static void connectPoints(List<Point> points, int leftPointPosition, int rightPointPosition) {
        points.get(leftPointPosition)
              .connectTo(points.get(rightPointPosition));
        points.get(rightPointPosition)
              .connectTo(points.get(leftPointPosition));
    }

}

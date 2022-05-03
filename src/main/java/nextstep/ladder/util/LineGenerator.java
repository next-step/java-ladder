package nextstep.ladder.util;

import nextstep.ladder.domain.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.*;

public abstract class LineGenerator {

    private static final List<Boolean> TRUE_OR_FALSE = Arrays.asList(true, false);
    private static final int PREVIOUS_POINT = -1;
    private static final boolean EMPTY_LINE = false;

    public static List<Point> createLine(int countOfPerson) {
        List<Point> points = new ArrayList<>();

        drawFirstPoint(points);

        for (int i = 1; i < countOfPerson - 1; i++) {
            if (previousPointDontHaveLine(points, i)) {
                points.add(drawLineOrNot());
                continue;
            }

            points.add(notDrawLine());
        }

        lastPointDontHaveLine(points);

        return points;
    }

    private static void drawFirstPoint(List<Point> points) {
        points.add(drawLineOrNot());
    }

    private static Point drawLineOrNot() {
        shuffle(TRUE_OR_FALSE);
        return Point.from(TRUE_OR_FALSE.get(0));
    }

    private static Point notDrawLine() {
        return Point.from(EMPTY_LINE);
    }

    private static Boolean previousPointDontHaveLine(List<Point> points, int currentPoint) {
        return points.get(currentPoint + PREVIOUS_POINT).isFalse();
    }

    private static void lastPointDontHaveLine(List<Point> points) {
        points.add(notDrawLine());
    }

}

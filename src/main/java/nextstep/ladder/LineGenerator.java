package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.*;

public abstract class LineGenerator {

    private static final List<Boolean> TRUE_OR_FALSE = Arrays.asList(true, false);

    public static List<Boolean> createLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();

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

    private static void drawFirstPoint(List<Boolean> points) {
        points.add(drawLineOrNot());
    }

    private static Boolean drawLineOrNot() {
        shuffle(TRUE_OR_FALSE);
        return TRUE_OR_FALSE.get(0);
    }

    private static Boolean notDrawLine() {
        return false;
    }

    private static Boolean previousPointDontHaveLine(List<Boolean> points, int i) {
        return !points.get(i - 1);
    }

    private static void lastPointDontHaveLine(List<Boolean> points) {
        points.add(notDrawLine());
    }

}

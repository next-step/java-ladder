package ladder.utils;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LadderGenerator {
    private static final List<Boolean> LINE_POINT = Arrays.asList(true, false);
    private static final int POINT_INDEX = 0;

    public static Ladder createLadder(int userCount, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(createLine(userCount));
        }

        return new Ladder(lines);
    }

    private static Line createLine(int userCount) {
        Collections.shuffle(LINE_POINT);

        List<Boolean> points = new ArrayList<>();

        points.add(LINE_POINT.get(POINT_INDEX));

        for (int i = 1; i < userCount - 1; i++) {
            addPoints(points, i);
        }

        points.add(false);

        return new Line(points);
    }

    private static void addPoints(List<Boolean> points, int index) {
        if (points.get(index - 1)) {
            points.add(false);

            return;
        }

        Collections.shuffle(LINE_POINT);

        points.add(LINE_POINT.get(POINT_INDEX));
    }
}

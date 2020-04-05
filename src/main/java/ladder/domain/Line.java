package ladder.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final List<Boolean> LINE_POINT = Arrays.asList(true, false);
    private static final int POINT_INDEX = 0;

    @Getter
    private List<Boolean> points;

    private Line(int userCount) {
        Collections.shuffle(LINE_POINT);

        points = new ArrayList<>();
        points.add(LINE_POINT.get(POINT_INDEX));

        for (int i = 1; i < userCount - 1; i++) {
            addPoints(points, i);
        }

        points.add(false);
    }

    public static List<Line> listOf(int userCount, int lineHeight) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < lineHeight; i++) {
            lines.add(new Line(userCount));
        }

        return lines;
    }

    private void addPoints(List<Boolean> points, int index) {
        if (points.get(index - 1)) {
            points.add(false);

            return;
        }

        Collections.shuffle(LINE_POINT);

        points.add(LINE_POINT.get(POINT_INDEX));
    }
}

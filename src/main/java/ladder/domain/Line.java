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
            points.add(getPoint(i));
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

    private Boolean getPoint(int index) {
        if (this.points.get(index - 1)) {
            return false;
        }

        Collections.shuffle(LINE_POINT);

        return LINE_POINT.get(POINT_INDEX);
    }
}

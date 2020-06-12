package ladder.domain;

import ladder.utils.GenerateRandomBoolean;

import java.util.ArrayList;
import java.util.List;

public class Creator {
    private static List<Boolean> points;
    private static int countOfPerson;

    public static Ladder createLadder(final int personCount, final int ladderHeight) {
        countOfPerson = personCount;

        List<Line> lines = new ArrayList<>();
        for (int idx = 0; idx < ladderHeight; idx++) {
            points = new ArrayList<>();

            Line line = createLine(false, 1);
            lines.add(line);
        }
        return new Ladder(lines);
    }

    private static Line createLine(final boolean presentHasLine, final int nextPosition) {
        if (nextPosition > countOfPerson) {
            return new Line(points);
        }

        points.add(presentHasLine);
        if (presentHasLine) {
            createLine(false, nextPosition + 1);
        } else {
            createLine(isCreate(), nextPosition + 1);
        }
        return new Line(points);
    }

    private static boolean isCreate() {
        return GenerateRandomBoolean.isMove();
    }
}

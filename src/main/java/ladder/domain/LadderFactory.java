package ladder.domain;

import ladder.utils.GenerateRandomBoolean;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    private static List<Direction> points;
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
        if (nextPosition == countOfPerson) {
            points.add(new Direction(presentHasLine, false));
            return new Line(points);
        }

        boolean nextHasLine = isCreate();
        if (presentHasLine) {
            nextHasLine = false;
        }
        points.add(new Direction(presentHasLine, nextHasLine));
        return createLine(nextHasLine, nextPosition + 1);
    }

    private static boolean isCreate() {
        return GenerateRandomBoolean.isMove();
    }
}

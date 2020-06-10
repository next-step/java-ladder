package ladder.domain;

import ladder.utils.GenerateRandomBoolean;

import java.util.ArrayList;
import java.util.List;

public class LineCreator {
    private final List<Boolean> points;
    private final int countOfPerson;

    public LineCreator(final int countOfPerson) {
        this.points = new ArrayList<>();
        this.countOfPerson = countOfPerson;
    }

    private boolean isCreate() {
        return GenerateRandomBoolean.isMove();
    }

    public Line createLine(final boolean presentHasLine, final int nextPosition) {
        if (nextPosition > countOfPerson) {
            return new Line(points);
        }

        points.add(presentHasLine);
        if (presentHasLine) {
            createLine(false,nextPosition+1);
        } else {
            createLine(isCreate(),nextPosition+1);
        }
        return new Line(points);
    }
}

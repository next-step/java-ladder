package ladder.domain;

import ladder.utils.GenerateRandomBoolean;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points = new ArrayList<>();
    private final int countOfPerson;

    public Line(final int countOfPerson) {
        this.countOfPerson = countOfPerson;
    }

    private boolean isCreate() {
        return GenerateRandomBoolean.isMove();
    }

    public void createLine(final boolean presentHasLine, final int nextPosition) {
        if (nextPosition > countOfPerson) {
            return;
        }

        points.add(presentHasLine);
        if (presentHasLine) {
            createLine(false, nextPosition + 1);
        } else {
            createLine(isCreate(), nextPosition + 1);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

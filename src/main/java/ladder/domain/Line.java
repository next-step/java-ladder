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

    public void createLine(final boolean preHasLine, final int presentPosition) {
        if (presentPosition == countOfPerson) {
            return;
        }

        if (preHasLine) {
            points.add(false);
            createLine(false, presentPosition + 1);
        } else {
            boolean nowHasLine = isCreate();
            points.add(nowHasLine);
            createLine(nowHasLine, presentPosition + 1);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

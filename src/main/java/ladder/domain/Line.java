package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    public static final boolean NO_LINE = false;

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, LineCondition lineCondition) {
        addValue(0, lineCondition.lineExist());
        for (int i = 1; i < countOfPerson - 1; i++) {
            addBooleanValue(i, lineCondition);
        }
    }

    private void addValue(int index, boolean pointExist) {
        points.add(index, pointExist);
    }

    private void addBooleanValue(int index, LineCondition lineCondition) {
        if (prevLineExist(index)) {
            addValue(index, NO_LINE);
        }
        if (!prevLineExist(index)) {
            addValue(index, lineCondition.lineExist());
        }
    }

    private boolean prevLineExist(int index) {
        return points.get(index - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, PointCondition pointCondition) {
        addValue(0, pointCondition.pointExist());
        for (int i = 1; i < countOfPerson - 1; i++) {
            addBooleanValue(i, pointCondition);
        }
    }

    private void addValue(int index, boolean pointExist) {
        points.add(index, pointExist);
    }

    private void addBooleanValue(int index, PointCondition pointCondition) {
        if (prevLineExist(index)) {
            addValue(index, false);
        }
        if (!prevLineExist(index)) {
            addValue(index, pointCondition.pointExist());
        }
    }

    private boolean prevLineExist(int index) {
        return points.get(index - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

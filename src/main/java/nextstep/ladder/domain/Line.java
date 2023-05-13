package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int BEGIN_INDEX = 0;
    private static final boolean EXIST_POINT = true;
    private static final boolean NON_EXIST_POINT = false;
    private static final double HALF = 0.5;

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        makeLine(countOfPerson);
    }

    public void makeLine(int countOfPerson) {
        for (int i = BEGIN_INDEX; i < countOfPerson; i++) {
            addPoint(i);
        }
    }

    private void addPoint(int idx) {
        if (BEGIN_INDEX == idx) {
            points.add(NON_EXIST_POINT);
            return;
        }

        if (isMakeable(idx)) {
            points.add(EXIST_POINT);
            return;
        }
        points.add(NON_EXIST_POINT);
    }

    private boolean isMakeable(int idx) {
        return isPrevPointNonExist(idx) && existCriteria();
    }

    private boolean isPrevPointNonExist(int idx) {
        return NON_EXIST_POINT == points.get(idx - 1);
    }

    private boolean existCriteria() {
        return HALF < Math.random();
    }

    public List<Boolean> points() {
        return points;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}

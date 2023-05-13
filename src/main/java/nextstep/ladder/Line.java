package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final double HALF = 0.5;

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        makeLine(countOfPerson);
    }

    public void makeLine(int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            makePoint(i);
        }
    }

    private void makePoint(int idx) {
        if (idx == 0) {
            points.add(false);
            return;
        }

        if (isMakeable(idx)) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    private boolean isMakeable(int idx) {
        return points.get(idx - 1) == false && HALF < Math.random();
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

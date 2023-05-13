package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, List<Boolean> makeables) {
        makeLine(countOfPerson, makeables);
    }

    public void makeLine(int countOfPerson, List<Boolean> makeables) {
        boolean prevLine = false;

        for (int i = 0; i < countOfPerson - 1; i++) {
            prevLine = makeLine(prevLine, makeables.get(i));
        }
    }

    private boolean makeLine(boolean prevLine, boolean makeCriteria) {
        if (isMakeable(prevLine, makeCriteria)) {
            points.add(true);
            return true;
        }
        points.add(false);
        return false;
    }

    public List<Boolean> points() {
        return points;
    }

    public boolean isMakeable(boolean prevLine, boolean makeCriteria) {
        return !prevLine && makeCriteria;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}

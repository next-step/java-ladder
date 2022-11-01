package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPerson, LineStrategy lineStrategy) {
        points = new ArrayList<>();

        for (int i = 0; i < countOfPerson; i++) {
            addPoints(i, countOfPerson, lineStrategy);
        }
    }

    public Boolean existPoint(int idx) {
        return points.get(idx);
    }

    private void addPoints(int idx, int countOfPerson, LineStrategy lineStrategy) {
        if (addablePoint(idx, countOfPerson)) {
            points.add(lineStrategy.addLine());
            return;
        }
        points.add(false);
    }

    private boolean addablePoint(int idx, int countOfPerson) {
        if (idx == countOfPerson - 1) {
            return false;
        }
        return points.isEmpty() || !points.get(idx - 1);
    }
}

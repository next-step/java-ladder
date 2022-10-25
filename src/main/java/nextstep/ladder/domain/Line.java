package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points;
    private LineStrategy lineStrategy;

    public Line(int countOfPerson, LineStrategy lineStrategy) {
        points = new ArrayList<>();
        this.lineStrategy = lineStrategy;

        for (int i = 0; i < countOfPerson; i++) {
            addPoints(i);
        }
    }

    public Boolean existPoint(int idx) {
        return points.get(idx);
    }

    private void addPoints(int idx) {
        if (points.isEmpty() || !points.get(idx - 1)) {
            points.add(lineStrategy.addLine());
            return;
        }
        points.add(false);
    }
}

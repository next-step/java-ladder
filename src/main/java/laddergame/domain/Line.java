package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, SelectStrategy selectStrategy) {
        initializePoints(countOfPerson);
        selectPoints(selectStrategy);
    }

    private void initializePoints(int countOfPerson) {
        for (int i = 0; i < countOfPerson; ++i) {
            points.add(false);
        }
    }

    private void selectPoints(SelectStrategy selectStrategy) {
        for (int i = 1; i < points.size(); ++i) {
            if (points.get(i-1)) {
                continue;
            }
            if (selectStrategy.canSelect()) {
                points.set(i, true);
            }
        }
    }

    public List<Boolean> getLine() {
        return points;
    }
}

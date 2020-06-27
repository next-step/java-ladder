package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, GeneratePointStrategy strategy) {
        createPoints(countOfPerson, strategy);
    }

    private void createPoints(int countOfPerson, GeneratePointStrategy strategy) {
        points.add(false);

        for (int i = 1; i < countOfPerson; i++) {
            points.add(strategy.isLine(points.get(i - 1)));
        }
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}

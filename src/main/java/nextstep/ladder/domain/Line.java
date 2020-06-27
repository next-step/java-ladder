package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, GeneratePointStrategy strategy) {
        createPoints(countOfPerson, strategy);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson, new RandomPointStrategy());
    }

    private void createPoints(int countOfPerson, GeneratePointStrategy strategy) {
        points.add(false);

        for (int i = 1; i < countOfPerson; i++) {
            points.add(strategy.isLine(points.get(i - 1)));
        }
    }
}

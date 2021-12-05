package nextstep.laddergame.model;

import java.util.ArrayList;
import java.util.List;

import nextstep.laddergame.utils.RandomUtils;

public class Line {

    private static final int BOOLEAN_LIMIT = 2;

    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        points.add(new Point(RandomUtils.generate(BOOLEAN_LIMIT)));
        for (int i = 1; i < countOfPerson; i++) {
            if (mustEmpty(i)) {
                points.add(Point.empty());
            }
            points.add(new Point(RandomUtils.generate(BOOLEAN_LIMIT)));
        }
    }

    private boolean mustEmpty(int i) {
        return points.get(i - 1).hasLine();
    }
}

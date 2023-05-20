package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        this(countOfPerson, DefalutLineBuildStrategy.getInstance());
    }

    public Line(int countOfPerson, LineBuildStrategy lineBuildStrategy) {
        this.points = makePoints(countOfPerson, lineBuildStrategy);
    }

    private List<Boolean> makePoints(int countOfPerson, LineBuildStrategy lineBuildStrategy) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < countOfPerson - 1; i++) {
            if (i != 0 && points.get(i - 1)) {
                points.add(false);
                continue;
            }
            points.add(lineBuildStrategy.build());
        }
        return points;
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

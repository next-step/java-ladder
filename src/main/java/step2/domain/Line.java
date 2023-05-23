package step2.domain;

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
        return lineBuildStrategy.build(countOfPerson);
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

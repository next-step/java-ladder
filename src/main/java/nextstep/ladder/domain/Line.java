package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        this(countOfPerson, new RandomLineStrategy());
    }

    public Line(int countOfPerson, LineStrategy strategy) {
        this(generatePoints(countOfPerson, strategy));
    }

    private static List<Boolean> generatePoints(int countOfPerson, LineStrategy strategy) {
        int pointCount = countOfPerson - 1;

        if (pointCount <= 0) {
            return new ArrayList<>();
        }

        return Stream.iterate(strategy.generate(), previous -> !previous && strategy.generate())
                .limit(pointCount)
                .toList();
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

}

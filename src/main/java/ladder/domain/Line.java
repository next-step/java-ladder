package ladder.domain;

import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;

    public Line(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        points.add(false);

        IntStream.range(1, countOfPerson)
                 .forEach(point -> points.add(PointStrategy.generate(points.get(point - 1))));

        this.points = points;
    }
    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }


}
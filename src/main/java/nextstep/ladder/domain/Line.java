package nextstep.ladder.domain;

import java.util.stream.IntStream;

public class Line {
    private Points points;

    private Line(Points points) {
        this.points = points;
    }

    public static Line create(int countOfPerson) {
        Points points = Points.create();
        IntStream.range(0, countOfPerson)
                .forEach(num -> points.add());
        return new Line(points);
    }

    public boolean getPointsIndex(int index) {
        return points.get(index);
    }
}

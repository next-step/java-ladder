package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line create(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        IntStream.range(0, countOfPerson)
                .forEach(num -> points.add(false));
        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

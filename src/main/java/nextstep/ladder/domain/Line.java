package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line create(int countOfPerson) {
        if (countOfPerson == 1) {
            return new Line(Collections.singletonList(false));
        }
        List<Boolean> points = createPoints(countOfPerson);
        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private static List<Boolean> createPoints(int countOfPerson) {
        List<Boolean> points = new ArrayList<>(Collections.singletonList(false));
        IntStream.range(1, countOfPerson)
                .forEach(num -> points.add(!points.get(num - 1)));
        return points;
    }
}

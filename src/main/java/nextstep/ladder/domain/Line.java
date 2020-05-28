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
        List<Boolean> points = new ArrayList<>(addFirstPoint());
        IntStream.range(1, countOfPerson)
                .forEach(num -> {
                    if (points.get(num - 1)) {
                        points.add(false);
                    } else {
                        points.add(true);
                    }
                });
        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private static List<Boolean> addFirstPoint() {
        return Collections.singletonList(false);
    }
}

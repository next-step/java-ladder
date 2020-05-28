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
                .forEach(num -> {
                    if (num == 0) {
                        points.add(false);
                    } else {
                        if (points.get(num - 1)) {
                            points.add(false);
                        } else {
                            points.add(true);
                        }
                    }
                });
        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

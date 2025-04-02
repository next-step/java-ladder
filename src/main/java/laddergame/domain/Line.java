package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson; ++i) {
            points.add(false);
        }
        selectHorizontalPoints();
    }

    private void selectHorizontalPoints() {
        Random random = new Random();
        for (int i = 1; i < points.size(); ++i) {
            if (points.get(i-1)) {
                continue;
            }
            if (random.nextInt(2) == 0) {
                points.set(i, true);
            }
        }
    }

    public String getLineString() {
        return points.stream()
                .map(point -> point ? "-----|" : "     |")
                .collect(Collectors.joining());
    }
}

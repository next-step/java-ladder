package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        validateCountOfPerson(countOfPerson);
        initPoints(countOfPerson);
    }

    private void initPoints(int countOfPerson) {
        points.add(new Point());

        IntStream.range(1, countOfPerson)
                .forEach(i -> {
                    Point previousPoint = points.get(points.size() - 1);
                    points.add(new Point(previousPoint));
                });
    }

    private void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < 1) {
            throw new IllegalArgumentException("참여자는 1명 이상이어야 합니다.");
        }
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }
}

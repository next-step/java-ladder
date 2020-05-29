package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PointsNeedMoreThanOnePersonException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_COUNT_OF_PERSON = 1;
    private Points points;

    private Line(Points points) {
        this.points = points;
    }

    public static Line create(int countOfPerson) {
        countOfPersonValidation(countOfPerson);
        Points points = Points.create();
        IntStream.range(0, countOfPerson)
                .forEach(num -> points.add());
        return new Line(points);
    }

    public int size() {
        return points.size();
    }

    public boolean getPointsIndex(int index) {
        return points.get(index);
    }

    public List<Boolean> getPointsValue() {
        return new ArrayList<>(this.points.values);
    }

    private static void countOfPersonValidation(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_PERSON) {
            throw new PointsNeedMoreThanOnePersonException("Need more than one people to make line");
        }
    }
}

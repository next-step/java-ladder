package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PointsNeedMoreThanOnePersonException;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MIN_COUNT_OF_PERSON = 1;
    private Points points;

    private Line(Points points) {
        this.points = points;
    }

    public static Line create(int countOfPerson, PointAddStrategy pointAddStrategy) {
        countOfPersonValidation(countOfPerson);
        if (countOfPerson == 1) {
            return new Line(Points.create());
        }
        Points points = Points.create();
        for (int i = 1; i < countOfPerson; i++) {
            points = points.add(pointAddStrategy);
        }
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

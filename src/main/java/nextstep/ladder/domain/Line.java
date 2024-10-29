package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String VALIDATE_COUNT_PERSON = "참여자는 2명 이상이어야 합니다.";
    private List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        validateCountOfPerson(countOfPerson);
        initPoints(countOfPerson);
    }

    private void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException(VALIDATE_COUNT_PERSON);
        }
    }

    private void initPoints(int countOfPerson) {
        points.add(new Point());
        for (int i = 1; i < countOfPerson - 1; i++) {
            points.add(new Point(points.get(i - 1)));
        }
    }

    public List<Point> getPoints() {
        return points;
    }
}

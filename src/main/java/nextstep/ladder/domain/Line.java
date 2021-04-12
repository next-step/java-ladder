package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final String PLAYER_COUNT_VALIDATE_MESSAGE = "참여자는 2명 이상이여야 합니다";
    private static final int MINIMUM_PLAYER_BOUND = 2;
    private static final int RIGHT = 1;
    private static final int LEFT = -1;
    private static final int STAY = 0;

    private final List<Point> points;

    protected Line(List<Boolean> points) {
        this.points = points.stream()
                .map(Point::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public Line(int countOfPerson) {
        validatePersonCount(countOfPerson);
        this.points = createPoints(countOfPerson);
    }

    private void validatePersonCount(int countOfPerson) {
        if (countOfPerson < MINIMUM_PLAYER_BOUND) {
            throw new IllegalArgumentException(PLAYER_COUNT_VALIDATE_MESSAGE);
        }
    }

    private List<Point> createPoints(int countOfPerson) {
        return new PointGenerator().generate(countOfPerson);
    }

    public int pointSize() {
        return points.size();
    }

    public List<Point> readOnlyPoints() {
        return Collections.unmodifiableList(points);
    }

    public int moveWhich(int idx) {
        if (idx >= points.size()) {
            return moveLeft(idx);
        }
        if (idx < 0) {
            return moveRight(idx);
        }
        if (points.get(idx).isConnected()) {
            return moveRight(idx);
        }
        if (idx > 0 && points.get(idx - 1).isConnected()) {
            return moveLeft(idx);
        }
        return bypass(idx);
    }

    private int bypass(int idx) {
        return idx + STAY;
    }

    private int moveLeft(int idx) {
        return idx + LEFT;
    }

    private int moveRight(int idx) {
        return idx + RIGHT;
    }
}

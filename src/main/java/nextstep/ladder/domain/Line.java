package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private static final int MINIMUM_COUNT_OF_PERSON = 2;

    private final List<Boolean> points;

    public Line (List<Boolean> points) {
        this.points = points;
    }

    public Line (int countOfPerson, LineStrategy lineStrategy) {
        if (countOfPerson < MINIMUM_COUNT_OF_PERSON) {
            throw new IllegalArgumentException("사람은 " + MINIMUM_COUNT_OF_PERSON + "명 이상이어야 합니다. (사람수: " + countOfPerson + "명");
        }
        this.points = lineStrategy.generate(countOfPerson - 1);
    }

    public int move(int currentPosition) {
        if (currentPosition > 0 && points.get(currentPosition - 1)) {
            return currentPosition - 1;
        }
        if (currentPosition < points.size() && points.get(currentPosition)) {
            return currentPosition + 1;
        }
        return currentPosition;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

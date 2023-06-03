package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

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
        List<Boolean> points = lineStrategy.generate(countOfPerson - 1);
        if (isInvalidPoints(points)) {
            throw new IllegalStateException("내부 오류: 라인이 겹치도록 생성되었습니다.");
        }
        this.points = points;
    }

    private boolean isInvalidPoints(List<Boolean> points) {
        return IntStream.range(0, points.size() - 1)
                .anyMatch(i -> points.get(i) && points.get(i + 1));
    }

    public int move(int currentPosition) {
        boolean canMoveLeft = currentPosition > 0 && points.get(currentPosition - 1);
        boolean canMoveRight = currentPosition < points.size() && points.get(currentPosition);
        return currentPosition + PositionChange.of(canMoveLeft, canMoveRight).getMoveAmount();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

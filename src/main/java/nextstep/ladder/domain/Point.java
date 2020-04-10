package nextstep.ladder.domain;

import nextstep.ladder.domain.step.Direction;

/**
 * LadderLine의 두 점과 현재 위치를 Point로 추상화
 * LadderLine에서 위치와 각 점의 방향을 관리
 */
public class Point {

    private final int linePosition;
    private final Direction direction;

    public Point(int linePosition, Direction direction) {
        this.linePosition = linePosition;
        this.direction = direction;
    }

    public static Point of(int linePosition, Direction direction) {
        return new Point(linePosition, direction);
    }

    public int move() {
        if(direction.isLeft()) {
            return linePosition - 1;
        }

        if(direction.isRight()) {
            return linePosition + 1;
        }

        return linePosition;
    }
}

package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;

public interface Point {
    int movePosition(int currentPosition);
    int getDirection();
    MoveDirection getMoveDirection();
    boolean isLeft();
    boolean isRight();
    boolean isStay();
}

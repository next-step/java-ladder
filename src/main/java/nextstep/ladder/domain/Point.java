package nextstep.ladder.domain;

import nextstep.ladder.data.MoveDirection;

public interface Point {
    int movePosition(int currentPosition);
    int getMoveDirection();
}

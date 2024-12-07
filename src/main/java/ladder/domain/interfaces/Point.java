package ladder.domain.interfaces;

import ladder.domain.interfaces.enums.MoveStatus;

public interface Point {
    Point next(boolean right);

    Point last();

    boolean getRight();

    MoveStatus move();
}

package ladder.domain.interfaces;

import ladder.domain.ns.NsPoint;
import ladder.domain.interfaces.enums.MoveStatus;

public interface Point {
    NsPoint next(boolean right);

    NsPoint last();

    boolean getRight();

    MoveStatus move();
}

package ladder.core;

import ladder.domain.point.LadderPoint;

public interface LadderLine extends Iterable<LadderPoint> {
    int move(final int index);

    int size();
}

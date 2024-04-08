package nextstep.ladder.domain.lines.point;

import nextstep.ladder.domain.lines.point.impl.PointImpl;

public interface Point {

    PointImpl decideNextPoint(Boolean randomBoolean);

    boolean isPointFalse();

    boolean isPointTrue();
}

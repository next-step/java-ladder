package nextstep.ladder.domain.lines.strategy.point;

import nextstep.ladder.domain.Point;

public interface PointCreationStrategy {

    Point createNextPoint(Point currentPoint);
}

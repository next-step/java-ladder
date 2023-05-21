package nextstep.laddergame.domain.strategy;

import nextstep.laddergame.domain.Point;

@FunctionalInterface
public interface LineStrategy {

  boolean canCreateLine(Point leftPoint, Point rightPoint);
}

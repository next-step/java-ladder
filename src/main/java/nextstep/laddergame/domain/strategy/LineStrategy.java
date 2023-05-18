package nextstep.laddergame.domain.strategy;

import nextstep.laddergame.domain.Point;

@FunctionalInterface
public interface LineStrategy {

  boolean isCreateLine(Point leftPoint, Point rightPoint);
}

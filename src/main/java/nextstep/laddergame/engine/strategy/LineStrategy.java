package nextstep.laddergame.engine.strategy;

import nextstep.laddergame.engine.Point;

@FunctionalInterface
public interface LineStrategy {

  boolean canCreateLine(Point leftPoint, Point rightPoint);
}

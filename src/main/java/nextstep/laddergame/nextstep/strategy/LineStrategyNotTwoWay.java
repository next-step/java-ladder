package nextstep.laddergame.nextstep.strategy;

import nextstep.laddergame.engine.Point;
import nextstep.laddergame.engine.strategy.LineStrategy;

public class LineStrategyNotTwoWay implements LineStrategy {

  @Override
  public boolean canCreateLine(Point leftPoint, Point rightPoint) {
    return !leftPoint.checkLeftWay() && !rightPoint.checkRightWay();
  }
}

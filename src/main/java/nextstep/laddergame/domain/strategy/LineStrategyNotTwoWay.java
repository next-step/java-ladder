package nextstep.laddergame.domain.strategy;

import nextstep.laddergame.domain.Point;

public class LineStrategyNotTwoWay implements LineStrategy {

  @Override
  public boolean canCreateLine(Point leftPoint, Point rightPoint) {
    return !leftPoint.checkLeftWay() && !rightPoint.checkRightWay();
  }
}

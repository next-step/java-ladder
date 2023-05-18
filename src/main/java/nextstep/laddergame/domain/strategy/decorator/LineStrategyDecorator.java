package nextstep.laddergame.domain.strategy.decorator;

import nextstep.laddergame.domain.Point;
import nextstep.laddergame.domain.strategy.LineStrategy;

public class LineStrategyDecorator implements LineStrategy {

  private LineStrategy lineStrategy;

  public LineStrategyDecorator(LineStrategy lineStrategy) {
    this.lineStrategy = lineStrategy;
  }

  @Override
  public boolean isCreateLine(Point leftPoint, Point rightPoint) {
    return lineStrategy.isCreateLine(leftPoint, rightPoint);
  }
}

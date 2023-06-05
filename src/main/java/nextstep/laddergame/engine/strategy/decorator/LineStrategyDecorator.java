package nextstep.laddergame.engine.strategy.decorator;

import nextstep.laddergame.engine.Point;
import nextstep.laddergame.engine.strategy.LineStrategy;

public class LineStrategyDecorator implements LineStrategy {

  private LineStrategy lineStrategy;

  public LineStrategyDecorator(LineStrategy lineStrategy) {
    this.lineStrategy = lineStrategy;
  }

  @Override
  public boolean canCreateLine(Point leftPoint, Point rightPoint) {
    return lineStrategy.canCreateLine(leftPoint, rightPoint);
  }
}

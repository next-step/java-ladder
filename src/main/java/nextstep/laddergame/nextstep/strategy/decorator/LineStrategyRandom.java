package nextstep.laddergame.nextstep.strategy.decorator;

import java.util.Random;
import nextstep.laddergame.engine.Point;
import nextstep.laddergame.engine.strategy.LineStrategy;
import nextstep.laddergame.engine.strategy.decorator.LineStrategyDecorator;

public class LineStrategyRandom extends LineStrategyDecorator {

  private static final Random random = new Random();

  public LineStrategyRandom(LineStrategy lineStrategy) {
    super(lineStrategy);
  }

  @Override
  public boolean canCreateLine(Point leftPoint, Point rightPoint) {
    return random.nextBoolean() && super.canCreateLine(leftPoint, rightPoint);
  }
}

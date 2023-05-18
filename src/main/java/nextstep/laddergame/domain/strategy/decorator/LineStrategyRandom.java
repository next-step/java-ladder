package nextstep.laddergame.domain.strategy.decorator;

import java.util.Random;
import nextstep.laddergame.domain.Point;
import nextstep.laddergame.domain.strategy.LineStrategy;

public class LineStrategyRandom extends LineStrategyDecorator {

  private static final Random random = new Random();

  public LineStrategyRandom(LineStrategy lineStrategy) {
    super(lineStrategy);
  }

  @Override
  public boolean isCreateLine(Point leftPoint, Point rightPoint) {
    return random.nextBoolean() && super.isCreateLine(leftPoint, rightPoint);
  }
}

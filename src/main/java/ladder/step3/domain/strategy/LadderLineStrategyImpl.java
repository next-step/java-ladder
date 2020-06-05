package ladder.step3.domain.strategy;

import ladder.step3.domain.Direction;

public class LadderLineStrategyImpl implements LadderLineStrategy {

  private static final LadderLineStrategy instance = new LadderLineStrategyImpl();

  private LadderLineStrategyImpl () {}

  @Override
  public Direction createLine(Direction prev) {
    if (prev == Direction.LEFT) {
      return Direction.createOptional(Direction.LEFT);
    }
    if (prev == Direction.RIGHT) {
      return Direction.createOptional(Direction.RIGHT);
    }
    return Direction.createAny();
  }

  public static LadderLineStrategy getInstance () {
    return instance;
  }
}

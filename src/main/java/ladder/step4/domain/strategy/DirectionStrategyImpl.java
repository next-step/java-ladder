package ladder.step4.domain.strategy;

import ladder.step4.domain.Direction;

public class DirectionStrategyImpl implements DirectionStrategy {

  private static final DirectionStrategy instance = new DirectionStrategyImpl();

  private DirectionStrategyImpl() {}

  @Override
  public Direction create(Direction prev) {
    if (prev == Direction.LEFT) {
      return Direction.createOptional(Direction.LEFT);
    }
    if (prev == Direction.RIGHT) {
      return Direction.createOptional(Direction.RIGHT);
    }
    return Direction.createAny();
  }

  public static DirectionStrategy getInstance () {
    return instance;
  }
}

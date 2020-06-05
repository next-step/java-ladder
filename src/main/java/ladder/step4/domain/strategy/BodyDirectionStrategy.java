package ladder.step4.domain.strategy;

import ladder.step4.domain.Direction;

public class BodyDirectionStrategy implements DirectionStrategy {

  private static final DirectionStrategy instance = new BodyDirectionStrategy();

  private BodyDirectionStrategy() {}

  @Override
  public Direction create(Direction prev) {
    if (prev == Direction.RIGHT) {
      return Direction.LEFT;
    }
    return Direction.createOptional(Direction.RIGHT);
  }

  public static DirectionStrategy getInstance () {
    return instance;
  }
}

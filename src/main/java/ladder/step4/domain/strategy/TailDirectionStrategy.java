package ladder.step4.domain.strategy;

import ladder.step4.domain.Direction;

public class TailDirectionStrategy implements DirectionStrategy {

  private static final DirectionStrategy instance = new TailDirectionStrategy();

  private TailDirectionStrategy() {}

  @Override
  public Direction create(Direction prev) {
    if (prev == Direction.RIGHT) {
      return Direction.LEFT;
    }
    return Direction.EMPTY;
  }

  public static DirectionStrategy getInstance () {
    return instance;
  }
}

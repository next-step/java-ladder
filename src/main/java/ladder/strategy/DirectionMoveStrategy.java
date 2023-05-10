package ladder.strategy;

import java.util.Random;

public class DirectionMoveStrategy implements MoveStrategy {

  private static final Random RANDOM = new Random();

  @Override
  public boolean movable() {
    return RANDOM.nextBoolean();
  }
}

package ladder.strategy;

import java.util.Random;

public class RandomLadderPointsStrategy implements LadderPointsStrategy {
  private static final Random random = new Random();

  @Override
  public boolean makeFirstPoint() {
    return random.nextBoolean();
  }

  @Override
  public boolean makeMiddlePoints(boolean leftPoint) {
    if (leftPoint) {
      return false;
    }

    return random.nextBoolean();
  }

  @Override
  public boolean makeLastPoint() {
    return false;
  }
}

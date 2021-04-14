package step2.strategy;

import java.util.Random;

public class RandomLadderPointsStrategy implements LadderPointsStrategy {
  @Override
  public boolean makeFirstPoint() {
    return new Random().nextBoolean();
  }

  @Override
  public boolean makeMiddlePoints(boolean leftPoint) {
    if (leftPoint) {
      return false;
    }

    return new Random().nextBoolean();
  }

  @Override
  public boolean makeLastPoint() {
    return false;
  }
}

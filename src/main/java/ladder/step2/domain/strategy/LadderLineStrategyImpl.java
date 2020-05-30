package ladder.step2.domain.strategy;

import java.util.Random;

public class LadderLineStrategyImpl implements LadderLineStrategy {
  private static final Random random = new Random();
  @Override
  public boolean createLine(boolean prev) {
    if (prev) {
      return false;
    }

    return random.nextBoolean();
  }
}

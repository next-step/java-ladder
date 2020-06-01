package ladder.step2.domain.strategy;

import java.util.Random;

public class LadderLineStrategyImpl implements LadderLineStrategy {
  private static final LadderLineStrategy instance = new LadderLineStrategyImpl();
  private static final Random random = new Random();

  private LadderLineStrategyImpl () {}

  @Override
  public boolean createLine(boolean prev) {
    if (prev) {
      return false;
    }

    return random.nextBoolean();
  }

  public static LadderLineStrategy getInstance () {
    return instance;
  }
}

package ladder.utils;

import java.util.Random;

public class ProbabilityStrategyRandom implements ProbabilityStrategy {

  private static final ProbabilityStrategyRandom SINGLETON = new ProbabilityStrategyRandom();
  private final Random random;

  private ProbabilityStrategyRandom() {
    random = new Random(System.currentTimeMillis());
  }

  public static ProbabilityStrategyRandom of() {
    return SINGLETON;
  }

  @Override
  public boolean result() {
    return fiftyPercent();
  }

  private boolean fiftyPercent() {
    return random.nextInt(100) > 50;
  }
}

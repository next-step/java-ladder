package ladder.domain.strategy;

import java.util.Random;

public class RandomPointGenerationStrategy implements NextPointGenerationStrategy {

  private static final Random RANDOM = new Random();

  @Override
  public boolean first() {
    return RANDOM.nextBoolean();
  }

  @Override
  public boolean nextBoolean(boolean prev) {
    if (!prev) {
      return RANDOM.nextBoolean();
    }
    return false;
  }


}

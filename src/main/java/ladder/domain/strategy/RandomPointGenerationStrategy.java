package ladder.domain.strategy;

import java.util.Random;

public class RandomPointGenerationStrategy implements NextPointGenerationStrategy {

  private final Random random;

  public RandomPointGenerationStrategy() {
    random = new Random();
  }

  public RandomPointGenerationStrategy(Random random) {
    this.random = random;
  }

  @Override
  public boolean nextBoolean(boolean prev) {
    if (!prev) {
      return random.nextBoolean();
    }
    return false;
  }


}

package ladder.domain;

import java.util.Random;

public class RandomPointGenerationStrategy implements NextPointGenerationStrategy {

  private static final Random RANDOM = new Random();
  @Override
  public boolean nextBoolean() {
    return RANDOM.nextBoolean();
  }

}

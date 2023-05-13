package ladder.domain.random;

import java.util.Random;

public class DefaultRandomBooleanGenerator implements RandomBooleanGenerator {

  private static final Random random = new Random();

  @Override
  public boolean getBoolean() {
    return random.nextBoolean();
  }
}

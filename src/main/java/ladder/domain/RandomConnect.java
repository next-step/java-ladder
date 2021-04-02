package ladder.domain;

import java.util.Random;

public class RandomConnect implements ConnectStrategy {

  private static final Random random = new Random();

  @Override
  public boolean connect() {
    return random.nextBoolean();
  }
}

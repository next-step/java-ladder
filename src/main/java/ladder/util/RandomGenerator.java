package ladder.util;

import java.util.Random;

public class RandomGenerator {

  private static final Random random = new Random();

  public static boolean nextBoolean() {
    return random.nextBoolean();
  }
}

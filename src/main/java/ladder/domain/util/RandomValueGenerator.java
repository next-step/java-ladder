package ladder.domain.util;

import java.util.Random;

public class RandomValueGenerator {

  private static final Random random = new Random();

  public static boolean randomBoolean() {
    return random.nextBoolean();
  }

}

package ladder.utils;

import java.util.Random;

public class RandomValueGenerator {

  private static final Random random = new Random();

  public static boolean generateBooleanValue() {
    return random.nextBoolean();
  }
}

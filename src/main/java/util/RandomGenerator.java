package util;

import java.util.Random;

public class RandomGenerator {

  private static final Random random = new Random();
  static {
    random.setSeed(System.currentTimeMillis());
  }

  private RandomGenerator() {
  }

  public static Boolean randomBool() {
    return random.nextBoolean();
  }
}

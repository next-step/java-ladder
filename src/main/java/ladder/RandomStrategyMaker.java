package ladder;

import java.util.Random;

public class RandomStrategyMaker {

  public static final int RANDOM_NUMBER_BOUNDARY = 10;
  public static final int TRUE_FALSE_STANDARD_NUMBER = 5;
  public static final Random random = new Random();

  public static boolean make(boolean beforeLine) {
    if(beforeLine) {
      return false;
    }
    return random.nextInt(RANDOM_NUMBER_BOUNDARY) >= TRUE_FALSE_STANDARD_NUMBER;
  }
}

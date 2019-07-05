package ladder;

import java.util.Random;

public class DirectionMaker {

  public static int CONDITION_NUMBER = 5;
  public static int RANDOM_NUMBER_BOUND = 10;

  static Random random = new Random();

  public static Direction make() {
    int randomNumber = random.nextInt(RANDOM_NUMBER_BOUND);
    if (CONDITION_NUMBER <= randomNumber) {
      return Direction.STRAIGHT;
    }
    return Direction.RIGHT;
  }

}

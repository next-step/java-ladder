package ladderGame.step3.util;

import java.util.Random;

public class RandomMove {

  private static final Random random = new Random();

  public static boolean createRandomMoveValue(){
    return random.nextBoolean();
  }
}
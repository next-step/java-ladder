package ladderGame.step2.util;

import java.util.Random;

public class RandomMove {

  private static Random random = new Random();

  public static boolean createRandomMoveValue(){
    return random.nextBoolean();
  }
}
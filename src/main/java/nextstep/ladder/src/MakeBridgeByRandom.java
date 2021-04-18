package nextstep.ladder.src;

import java.util.Random;

public class MakeBridgeByRandom implements MakeBridge {
  private static final int MAX_NUM = 2;
  private static final int STANDARD_NUM = 1;

  @Override
  public boolean make() {
    if(new Random().nextInt(MAX_NUM) == STANDARD_NUM) {
      return true;
    }
    return false;
  }
}

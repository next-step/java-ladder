package ladder.domain.strategy;

import java.util.Random;

public class RandomConnectStrategy implements ConnectStrategy {

  private final Random random;
  private boolean isLastConnect = false;

  public RandomConnectStrategy() {
    this.random = new Random();
  }

  @Override
  public boolean isConnect() {
    if (isLastConnect) {
      isLastConnect = false;
      return false;
    }
    boolean isConnect = random.nextBoolean();
    isLastConnect = isConnect;
    return isConnect;
  }
}

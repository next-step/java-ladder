package ladder.domain.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomConnectStrategy implements ConnectStrategy {

  private final List<Boolean> isConnects;


  public RandomConnectStrategy(int lineLength) {
    Random random = new Random();
    isConnects = new ArrayList<>();
    boolean isLastConnect = false;
    for (int i = 0; i < lineLength; i++) {
      boolean isConnect = random.nextBoolean();
      if (isLastConnect) {
        isConnect = false;
      }
      isConnects.add(isConnect);
      isLastConnect = isConnect;
    }
  }

  @Override
  public boolean isConnect(int lineIndex) {
    return isConnects.get(lineIndex);
  }
}

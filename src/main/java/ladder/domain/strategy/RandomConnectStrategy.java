package ladder.domain.strategy;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomConnectStrategy implements ConnectStrategy {

  private static final String INVALID_LINE_WIDTH_MSG = "라인의 길이는 0 이상이어야 합니다";
  private final List<Boolean> connects;

  public RandomConnectStrategy(int lineWidth) {
    if (lineWidth < 0) {
      throw new InvalidParameterException(INVALID_LINE_WIDTH_MSG);
    }
    Random random = new Random();
    connects = new ArrayList<>();
    boolean lastConnect = false;
    for (int i = 0; i < lineWidth - 1; i++) {
      boolean connect = isCurrentConnect(random.nextBoolean(), lastConnect);
      connects.add(connect);
      lastConnect = connect;
    }
    connects.add(false);
  }

  private boolean isCurrentConnect(boolean currConnect, boolean lastConnect) {
    if (lastConnect) {
      return false;
    }
    return currConnect;
  }

  @Override
  public List<Boolean> create() {
    return connects;
  }
}

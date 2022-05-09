package ladder.domain.strategy;

import java.util.List;

public class FixedConnectStrategy implements ConnectStrategy {

  private final List<Boolean> isConnects;
  private int index = 0;

  public FixedConnectStrategy(List<Boolean> isConnects) {
    this.isConnects = isConnects;
  }

  @Override
  public boolean isConnect() {
    return isConnects.get(index++);
  }
}

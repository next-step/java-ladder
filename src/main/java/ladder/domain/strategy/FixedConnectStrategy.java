package ladder.domain.strategy;

import java.util.List;

public class FixedConnectStrategy implements ConnectStrategy {

  private final List<Boolean> isConnects;

  public FixedConnectStrategy(List<Boolean> isConnects) {
    this.isConnects = isConnects;
  }

  @Override
  public boolean isConnect(int lineIndex) {
    return isConnects.get(lineIndex);
  }
}

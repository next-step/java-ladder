package ladder.domain.strategy;

import java.util.List;

public class FixedConnectStrategy implements ConnectStrategy {

  private final List<Boolean> connects;

  public FixedConnectStrategy(List<Boolean> connects) {
    this.connects = connects;
  }

  @Override
  public List<Boolean> create() {
    return connects;
  }
}

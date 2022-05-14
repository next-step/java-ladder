package ladder.domain.strategy;

import java.util.List;

public class FixedLadderConnectStrategy implements LadderConnectStrategy {

  private final List<List<Boolean>> connects;

  public FixedLadderConnectStrategy(List<List<Boolean>> connects) {
    this.connects = connects;
  }

  @Override
  public List<Boolean> create(int height) {
    return connects.get(height);
  }
}

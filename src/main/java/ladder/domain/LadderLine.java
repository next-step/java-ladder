package ladder.domain;

import java.util.List;
import ladder.domain.strategy.ConnectStrategy;

public class LadderLine {

  private final List<Boolean> isConnects;

  private LadderLine(List<Boolean> isConnects) {
    this.isConnects = isConnects;
  }

  public static LadderLine of(ConnectStrategy connectStrategy) {
    return new LadderLine(connectStrategy.create());
  }

  public boolean isConnect(int lineIdx) {
    return isConnects.get(lineIdx);
  }

  public int getLadderWidth() {
    return isConnects.size();
  }
}

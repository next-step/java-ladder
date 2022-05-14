package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.strategy.ConnectStrategy;

public class LadderLine {

  private final List<Boolean> isConnects;

  private LadderLine(List<Boolean> isConnects) {
    this.isConnects = isConnects;
  }

  public static LadderLine of(int width, ConnectStrategy connectStrategy) {
    List<Boolean> connects = new ArrayList<>();
    for (int i = 0; i < width; i++) {
      connects.add(connectStrategy.isConnect(i));
    }
    return new LadderLine(connects);
  }

  public boolean isConnect(int lineIdx) {
    return isConnects.get(lineIdx);
  }

  public int getLadderLength() {
    return isConnects.size();
  }
}

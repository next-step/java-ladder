package ladder.domain;

import java.util.List;

public class LadderLine {

  private final List<Boolean> isConnects;

  private LadderLine(List<Boolean> isConnects) {
    this.isConnects = isConnects;
  }

  public static LadderLine of(List<Boolean> isConnects) {
    return new LadderLine(isConnects);
  }

  public boolean isConnect(int lineIdx) {
    return isConnects.get(lineIdx);
  }

  public int getLadderWidth() {
    return isConnects.size();
  }
}

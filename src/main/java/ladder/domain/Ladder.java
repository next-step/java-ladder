package ladder.domain;

import java.util.List;
import ladder.domain.strategy.ConnectStrategy;

public class Ladder {

  private final LadderLines ladderLines;

  private Ladder(LadderLines ladderLines) {
    this.ladderLines = ladderLines;
  }

  public static Ladder of(int width, List<ConnectStrategy> connectStrategies) {
    return new Ladder(LadderLines.of(width, connectStrategies));
  }

  public boolean isConnect(int height, int lineIdx) {
    return ladderLines.isConnect(height, lineIdx);
  }

  public int getLadderHeight() {
    return ladderLines.height();
  }

  public LadderLine getLadderLine(int height) {
    return ladderLines.getLadderLine(height);
  }
}

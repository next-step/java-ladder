package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.strategy.ConnectStrategy;

public class Ladder {

  private final List<LadderLine> lines;

  private Ladder(List<LadderLine> lines) {
    this.lines = lines;
  }

  public static Ladder of(int userCount, List<ConnectStrategy> connectStrategies) {
    List<LadderLine> ladderLines = new ArrayList<>();
    for (int i = 0; i < connectStrategies.size(); i++) {
      ladderLines.add(LadderLine.of(userCount, connectStrategies.get(i)));
    }

    return new Ladder(ladderLines);
  }

  public boolean isConnect(int height, int userIdx) {
    return lines.get(height).isConnect(userIdx);
  }

  public int getLadderHeight() {
    return lines.size();
  }

  public LadderLine getLadderLine(int heightIdx) {
    return lines.get(heightIdx);
  }
}

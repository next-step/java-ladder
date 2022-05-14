package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.strategy.ConnectStrategy;

public class LadderLines {

  private final List<LadderLine> values;

  public LadderLines(List<LadderLine> ladderLines) {
    this.values = ladderLines;
  }

  public static LadderLines of(int width, List<ConnectStrategy> connectStrategies) {
    return new LadderLines(connectStrategies.stream()
        .map(c -> LadderLine.of(width, c))
        .collect(Collectors.toList()));
  }

  public boolean isConnect(int height, int lineIdx) {
    return values.get(height).isConnect(lineIdx);
  }

  public int height() {
    return values.size();
  }

  public LadderLine getLadderLine(int height) {
    return values.get(height);
  }
}

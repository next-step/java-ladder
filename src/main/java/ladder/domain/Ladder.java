package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.strategy.ConnectStrategy;

public class Ladder {

  private final List<LadderLine> lines;

  private Ladder(List<LadderLine> lines) {
    this.lines = lines;
  }

  public static Ladder of(int userCount, List<ConnectStrategy> connectStrategies) {
    return new Ladder(connectStrategies.stream()
        .map(c -> LadderLine.of(userCount, c))
        .collect(Collectors.toList()));
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

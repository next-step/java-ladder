package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.strategy.LadderConnectStrategy;

public class LadderLines {

  private final List<LadderLine> values;

  public LadderLines(List<LadderLine> ladderLines) {
    this.values = ladderLines;
  }

  public static LadderLines of(int height, LadderConnectStrategy ladderConnectStrategy) {
    return new LadderLines(IntStream.range(0, height)
        .mapToObj(h -> LadderLine.of(ladderConnectStrategy.create(h)))
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

package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.strategy.LadderConnectStrategy;

public class LadderPartLines {

  private final List<LadderPartLine> values;

  public LadderPartLines(List<LadderPartLine> ladderLines) {
    this.values = ladderLines;
  }

  public static LadderPartLines of(int height, LadderConnectStrategy ladderConnectStrategy) {
    return new LadderPartLines(IntStream.range(0, height)
        .mapToObj(h -> LadderPartLine.of(ladderConnectStrategy.create(h)))
        .collect(Collectors.toList()));
  }

  public boolean isLeftConnect(int height, int lineIdx) {
    return values.get(height).isLeftConnect(lineIdx);
  }

  public boolean isRightConnect(int height, int lineIdx) {
    return values.get(height).isRightConnect(lineIdx);
  }

  public int height() {
    return values.size();
  }

  public LadderPartLine getLadderLine(int height) {
    return values.get(height);
  }
}

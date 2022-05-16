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
    List<LadderPartLine> lines = IntStream.range(0, height).
        mapToObj(heightPont -> LadderPartLine.of(ladderConnectStrategy.create(heightPont)))
        .collect(Collectors.toList());

    return new LadderPartLines(lines);
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

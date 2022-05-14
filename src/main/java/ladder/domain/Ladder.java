package ladder.domain;

import java.security.InvalidParameterException;
import java.util.List;
import ladder.domain.strategy.ConnectStrategy;

public class Ladder {

  public static final String INVALID_HEIGHT_MSG = "사다리의 높이는 1 이상이어야 합니다.";
  private final LadderLines ladderLines;

  private Ladder(LadderLines ladderLines) {
    assertLadder(ladderLines);
    this.ladderLines = ladderLines;
  }

  public static Ladder of(List<ConnectStrategy> connectStrategies) {
    return new Ladder(LadderLines.of(connectStrategies));
  }

  private void assertLadder(LadderLines ladderLines) {
    if (ladderLines.height() == 0) {
      throw new InvalidParameterException(INVALID_HEIGHT_MSG);
    }
  }

  public int getLadderHeight() {
    return ladderLines.height();
  }

  public LadderLine getLadderLine(int height) {
    return ladderLines.getLadderLine(height);
  }

  public int getLadderWidth() {
    return ladderLines.getLadderLine(0).getLadderWidth();
  }
}

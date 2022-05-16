package ladder.domain;

import java.security.InvalidParameterException;
import ladder.domain.strategy.LadderConnectStrategy;

public class Ladder {

  public static final String INVALID_HEIGHT_MSG = "사다리의 높이는 1 이상이어야 합니다.";
  private final LadderPartLines ladderLines;

  private Ladder(LadderPartLines ladderLines) {
    assertLadder(ladderLines);
    this.ladderLines = ladderLines;
  }

  public static Ladder of(int height, LadderConnectStrategy ladderConnectStrategy) {
    return new Ladder(LadderPartLines.of(height, ladderConnectStrategy));
  }

  public int getLadderHeight() {
    return ladderLines.height();
  }

  public boolean isLeftConnect(int height, int width) {
    return ladderLines.isLeftConnect(height, width);
  }

  public boolean isRightConnect(int height, int width) {
    return ladderLines.isRightConnect(height, width);
  }

  public int getLadderWidth() {
    return ladderLines.getLadderLine(0).getLadderWidth();
  }

  private void assertLadder(LadderPartLines ladderLines) {
    if (ladderLines.height() == 0) {
      throw new InvalidParameterException(INVALID_HEIGHT_MSG);
    }
  }
}

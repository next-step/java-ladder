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

  public static Ladder of(int height,LadderConnectStrategy ladderConnectStrategy) {
    return new Ladder(LadderPartLines.of(height, ladderConnectStrategy));
  }

  private void assertLadder(LadderPartLines ladderLines) {
    if (ladderLines.height() == 0) {
      throw new InvalidParameterException(INVALID_HEIGHT_MSG);
    }
  }

  public int getLadderHeight() {
    return ladderLines.height();
  }

  public LadderPartLine getLadderLine(int height) {
    return ladderLines.getLadderLine(height);
  }

  public boolean isLeftConnect(int height, int width) {
    return getLadderLine(height).isLeftConnect(width);
  }

  public boolean isRightConnect(int height, int width) {
    return getLadderLine(height).isRightConnect(width);
  }

  public int getLadderWidth() {
    return ladderLines.getLadderLine(0).getLadderWidth();
  }
}

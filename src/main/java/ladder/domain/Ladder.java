package ladder.domain;

import java.security.InvalidParameterException;

public class Ladder {

  public static final String INVALID_HEIGHT_MSG = "사다리의 높이는 1 이상이어야 합니다.";
  private final LadderPartLines ladderLines;

  public Ladder(LadderPartLines ladderLines) {
    assertLadder(ladderLines);
    this.ladderLines = ladderLines;
  }

  public static Ladder of(int height, int width) {
    return new Ladder(LadderPartLines.of(height, width));
  }

  public int getLadderHeight() {
    return ladderLines.height();
  }

  private void assertLadder(LadderPartLines ladderLines) {
    if (ladderLines.height() == 0) {
      throw new InvalidParameterException(INVALID_HEIGHT_MSG);
    }
  }

  public int traverse(int startPartIndex) {
    return ladderLines.traverse(startPartIndex);
  }

  public LadderPartLines getLadderLines() {
    return ladderLines;
  }

  public int getWidth() {
    return ladderLines.getWidth();
  }

  public Connect getConnect(int heightIdx, int lineIdx) {
    return ladderLines.getConnect(heightIdx, lineIdx);
  }
}

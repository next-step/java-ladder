package ladder.domain.player;

import ladder.domain.ladder.line.point.LadderPointDirection;

public class PlayerPosition {

  private int currentLine;
  private int currentHeight;
  private LadderPointDirection previousMove;

  public PlayerPosition(int currentLine) {
    this.currentLine = currentLine;
    this.currentHeight = 0;
    this.previousMove = null;
  }

  public int getCurrentLine() {
    return currentLine;
  }

  public int getCurrentHeight() {
    return currentHeight;
  }

  public void move (LadderPointDirection direction) {
    boolean isMoved = direction.move(this);
    if (isMoved) {
      return;
    }

    // 이동 할 수 없는 경우 아래로 이동
    this.goDown();
  }

  public boolean goDown() {
    this.previousMove = LadderPointDirection.NONE;
    this.currentHeight++;
    return true;
  }

  public boolean goLeft() {
    if (isNotHorizontallyMovable(LadderPointDirection.LEFT)) {
      return false;
    }
    this.previousMove = LadderPointDirection.LEFT;
    this.currentLine--;
    return true;
  }

  public boolean goRight() {
    if (isNotHorizontallyMovable(LadderPointDirection.RIGHT)) {
      return false;
    }

    this.previousMove = LadderPointDirection.RIGHT;
    this.currentLine++;
    return true;
  }

  private boolean isHorizontallyMovable(LadderPointDirection moveTryDirection) {
    if (isStartPosition()) {
      return true;
    }

    return previousMove.getOppositeDirection() != moveTryDirection;
  }

  private boolean isNotHorizontallyMovable(LadderPointDirection moveTryDirection) {
    return !isHorizontallyMovable(moveTryDirection);
  }

  private boolean isStartPosition() {
    return previousMove == null;
  }
}

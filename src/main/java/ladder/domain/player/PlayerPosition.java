package ladder.domain.player;

import exception.ExceptionCode;
import exception.LadderGameException;
import ladder.domain.ladder.line.point.LadderPointDirection;

public class PlayerPosition {

  private int currentLine;
  private int currentHeight;
  private LadderPointDirection previousMove;

  public PlayerPosition(int currentLine, int currentHeight) {
    this.currentLine = currentLine;
    this.currentHeight = currentHeight;
    this.previousMove = LadderPointDirection.NONE;
  }

  public int getCurrentLine() {
    return currentLine;
  }

  public int getCurrentHeight() {
    return currentHeight;
  }

  public void goDown() {
    this.previousMove = LadderPointDirection.NONE;
    this.currentHeight++;
  }

  private void goLeft() {
    this.previousMove = LadderPointDirection.LEFT;
    this.currentLine--;
  }

  private void goRight() {
    this.previousMove = LadderPointDirection.RIGHT;
    this.currentLine++;
  }

  public void move (LadderPointDirection direction) {
    if (isHorizontallyMovable(direction)) {
      this.moveHorizontally(direction);
      return;
    }

    this.goDown();
  }

  private void moveHorizontally(LadderPointDirection direction) {
    if (direction == LadderPointDirection.RIGHT) {
      this.goRight();
      return;
    }

    if (direction == LadderPointDirection.LEFT) {
      this.goLeft();
      return;
    }

    throw new LadderGameException(ExceptionCode.CANNOT_MOVE_INVALID_DIRECTION);
  }

  private boolean isHorizontallyMovable(LadderPointDirection moveTryDirection) {
    if (isStartPosition() && moveTryDirection != LadderPointDirection.NONE) {
      return true;
    }

    if (moveTryDirection == LadderPointDirection.NONE) {
      return false;
    }

    return previousMove.getOppositeDirection() != moveTryDirection;
  }

  private boolean isStartPosition() {
    return this.currentHeight == 0 && this.currentLine == 0;
  }
}

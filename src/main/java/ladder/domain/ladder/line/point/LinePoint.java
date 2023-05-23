package ladder.domain.ladder.line.point;

import exception.ExceptionCode;
import exception.LadderGameException;

public class LinePoint {

  protected LadderPointDirection pointDirection;
  protected final int index;
  protected final boolean isStart;
  protected final boolean isEnd;

  public LinePoint (LinePoint linePoint) {
    this.index = linePoint.index;
    this.isStart = linePoint.isStart;
    this.isEnd = linePoint.isEnd;
    this.pointDirection = linePoint.pointDirection;
  }

  public LinePoint (int index) {
    this.index = index;
    this.pointDirection = LadderPointDirection.NONE;
    this.isStart = false;
    this.isEnd = false;
  }

  public LinePoint (int index, boolean isStart, boolean isEnd) {
    this.index = index;
    this.pointDirection = LadderPointDirection.NONE;
    this.isStart = isStart;
    this.isEnd = isEnd;
  }

  public LadderPointDirection getPointDirection() {
    return pointDirection;
  }

  public boolean isStartPoint() {
    return isStart;
  }

  public boolean isEndPoint() {
    return isEnd;
  }

  public int getIndex() {
    return index;
  }

  public void connect (LinePoint targetPoint) {
    if (this.index > targetPoint.index) {
      throw new LadderGameException(ExceptionCode.CANNOT_CONNECT_POINT_IN_REVERSE_ORDER);
    }

    this.pointDirection = LadderPointDirection.RIGHT;
    targetPoint.pointDirection = LadderPointDirection.LEFT;
  }
}

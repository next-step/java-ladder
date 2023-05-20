package ladder.domain.ladder.line.point;

import exception.ExceptionCode;
import exception.LadderGameException;

public class LinePoint {

  private LadderPointDirection pointDirection;
  private final int index;
  private final boolean isStart;
  private final boolean isEnd;

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

  public boolean isNotEdgePoint() {
    return !isStart && !isEnd;
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

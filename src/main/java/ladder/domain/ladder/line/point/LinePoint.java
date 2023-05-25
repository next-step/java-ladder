package ladder.domain.ladder.line.point;

import exception.ExceptionCode;
import exception.LadderGameException;

public class LinePoint {

  protected LadderPointDirection pointDirection;
  protected final int index;

  public LinePoint (LinePoint linePoint) {
    this.index = linePoint.index;
    this.pointDirection = linePoint.pointDirection;
  }

  public LinePoint (int index) {
    this.index = index;
    this.pointDirection = LadderPointDirection.NONE;
  }

  public LadderPointDirection getPointDirection() {
    return pointDirection;
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

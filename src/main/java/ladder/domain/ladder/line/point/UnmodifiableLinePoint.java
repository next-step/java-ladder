package ladder.domain.ladder.line.point;

import exception.ExceptionCode;
import exception.LadderGameException;

public class UnmodifiableLinePoint extends LinePoint {

  public UnmodifiableLinePoint(LinePoint linePoint) {
    super(linePoint);
  }

  public UnmodifiableLinePoint(int index) {
    super(index);
  }

  public UnmodifiableLinePoint(int index, boolean isStart, boolean isEnd) {
    super(index, isStart, isEnd);
  }

  @Override
  public void connect(LinePoint targetPoint) {
    throw new LadderGameException(ExceptionCode.CANNOT_MODIFY_LADDER_AFTER_CREATED);
  }
}

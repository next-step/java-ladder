package ladder.domain.ladder.line;

import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.List;
import ladder.domain.ladder.line.point.LadderPointDirection;
import ladder.domain.ladder.line.point.LinePoint;
import utils.ListUtils;

public class HorizontalLadderLine {

  private final List<LinePoint> points;

  public HorizontalLadderLine(int countOfPerson) {
    final LineGenerator lineGenerator = new LineGenerator();
    this.points = lineGenerator.generateNotConnectedPoints(countOfPerson);
  }

  public int getPointSize() {
    return this.points.size();
  }

  public List<LinePoint> getPoints() {
    return this.points;
  }

  public void connect(int pointIndex1, int pointIndex2) {
    LinePoint linePoint1 = this.getPointAt(pointIndex1);
    LinePoint linePoint2 = this.getPointAt(pointIndex2);
    if (isPreviousPointConnected(linePoint1)) {
      throw new LadderGameException(ExceptionCode.CANNOT_CONNECT_CONTINUOUS_POINT);
    }

    linePoint1.connect(linePoint2);
  }

  public boolean isPreviousPointConnected(LinePoint point) {
    if (point.isStartPoint()) {
      return false;
    }

    final LinePoint prePoint = this.getPointAt(point.getIndex() - 1);
    return isConnected(prePoint, point);
  }

  public LinePoint getPointAt(int index) {
    if (ListUtils.hasNotElementAt(this.points, index)) {
      throw new LadderGameException(ExceptionCode.LINE_POINT_NOT_FOUND);
    }
    return this.points.get(index);
  }

  private boolean isConnected(LinePoint linePoint1, LinePoint linePoint2) {
    return linePoint1.getPointDirection() == LadderPointDirection.RIGHT &&
        linePoint2.getPointDirection() == LadderPointDirection.LEFT;
  }
}

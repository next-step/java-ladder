package ladder.domain.Line;

import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.ladder.LadderPointDirection;
import utils.ListUtils;

public class Line {

  private final List<LinePoint> points;

  public Line (int countOfPerson) {
    final LineGenerator lineGenerator = new LineGenerator();
    this.points = lineGenerator.generateNotConnectedPoints(countOfPerson);
  }

  public int getPointSize() {
    return this.points.size();
  }

  public List<LinePoint> getPoints() {
    return this.points;
  }

  public boolean isConnected(LinePoint linePoint1, LinePoint linePoint2) {
    if(linePoint2.getIndex() - linePoint1.getIndex() != 1) {
      throw new LadderGameException(ExceptionCode.CONNECTION_CHECKED_NOT_SUPPORTED);
    }

    return linePoint1.getPointDirection() == LadderPointDirection.RIGHT &&
        linePoint2.getPointDirection() == LadderPointDirection.LEFT;
  }

  public void connect(int pointIndex1, int pointIndex2) {
    LinePoint linePoint1 = this.getPoint(pointIndex1);
    LinePoint linePoint2 = this.getPoint(pointIndex2);
    if (isPrePointConnected(linePoint1)) {
      throw new LadderGameException(ExceptionCode.CANNOT_CONNECT_CONTINUOUS_POINT);
    }

    linePoint1.connect(linePoint2);
  }

  public boolean isPrePointConnected(LinePoint point) {
    if (point.isStartPoint()) {
      return false;
    }

    final LinePoint prePoint = this.getPoint(point.getIndex() - 1);
    return isConnected(prePoint, point);
  }

  public LinePoint getPoint(int index) {
    if (ListUtils.hasNotElementAt(this.points, index)) {
      throw new LadderGameException(ExceptionCode.LINE_POINT_NOT_FOUND);
    }
    return this.points.get(index);
  }
}

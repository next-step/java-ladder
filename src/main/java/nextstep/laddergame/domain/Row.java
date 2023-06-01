package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Row {

  private List<Point> points;

  public Row(List<Point> points) {
    if (points.size() < 1) {
      throw new IllegalArgumentException("사다리의 넓이(Point 갯수)는 1보다 작을 수 없습니다.");
    }

    if (points.stream().anyMatch(Point::checkTwoWay)) {
      throw new IllegalArgumentException("Line은 겹칠 수 없습니다.");
    }

    this.points = points;
  }

  public List<Point> getPoints() {
    return Collections.unmodifiableList(points);
  }

  public Point getPoint(int location) {
    return points.get(location);
  }
}

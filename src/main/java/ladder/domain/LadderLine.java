package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {

  private final List<Point> points;

  private LadderLine(List<Point> points) {
    this.points = points;
  }

  public List<Point> line() {
    return Collections.unmodifiableList(points);
  }

  public static LadderLine createPoints(int countOfUser, MoveStrategy moveStrategy) {
    List<Point> userPoints = new ArrayList<>();
    Point point = Point.createFirstPoint(moveStrategy);

    userPoints.add(point);

    for (int index = 0; index < countOfUser - 1; index++) {
      point = point.createNextPoint(moveStrategy);
      userPoints.add(point);
    }

    userPoints.add(point.createLastPoint());

    return new LadderLine(userPoints);
  }
}

package ladder.domain;

import ladder.strategy.DirectionMoveStrategy;
import ladder.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {

  private static final int FIRST_AND_LAST_COUNT = 2;
  private final List<Point> points;

  private LadderLine(List<Point> points) {
    this.points = points;
  }

  public List<Point> points() {
    return Collections.unmodifiableList(points);
  }

  public static LadderLine createPoints(int countOfUser, MoveStrategy moveStrategy) {
    List<Point> userPoints = new ArrayList<>();
    Point point = Point.createFirstPoint(moveStrategy);

    userPoints.add(point);

    for (int index = 0; index < countOfUser - FIRST_AND_LAST_COUNT; index++) {
      point = point.createNextPoint(moveStrategy);
      userPoints.add(point);
    }

    userPoints.add(point.createLastPoint());

    return new LadderLine(userPoints);
  }
}

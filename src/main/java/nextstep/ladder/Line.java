package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
  private final List<Point> points = new ArrayList<>();

  public Line(int countOfPerson, DirectionStrategy strategy) {
    for (int i = 0; i < countOfPerson - 1; i++) {
      if (i > 0 && points.get(i - 1).hasLine()) {
        points.add(new Point(false));
      } else {
        points.add(new Point(strategy.generate()));
      }
    }
  }

  public List<Point> getPoints() {
    return points;
  }
}

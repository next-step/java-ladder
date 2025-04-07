package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Line {
  private final List<Boolean> points;

  public Line(int countOfPerson, Predicate<Integer> pointGenerator) {
    points = new ArrayList<>();
    boolean prevPoint = false;

    for (int i = 0; i < countOfPerson - 1; i++) {
      if (prevPoint) {
        points.add(false);
        prevPoint = false;
        continue;
      }

      boolean hasPoint = pointGenerator.test(i);
      points.add(hasPoint);
      prevPoint = hasPoint;
    }
  }

  public boolean hasPoint(int position) {
    return points.get(position);
  }

  public int getPointsSize() {
    return points.size();
  }
}

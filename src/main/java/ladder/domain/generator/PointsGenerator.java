package ladder.domain.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import ladder.domain.Point;
import ladder.domain.generator.Generator;

public class PointsGenerator implements Generator {


  private static final Random random = new Random();
  private final List<Point> points;
  private final int countOfPoint;

  public PointsGenerator(int countOfPoint) {
    points = new ArrayList<>();
    this.countOfPoint = countOfPoint;
  }

  @Override
  public List<Point> makePoints() {

    for (int i = 0; i< countOfPoint; i++) {
      points.add(makePoint());
    }

    return points;
  }

  private Point makePoint() {
    if (points.size() == 0) {
      return new Point(false);

    }

    Point prePoint = points.get(points.size() - 1);
    if (prePoint.isUsed()) {
      return new Point(false);

    }

    return new Point(random.nextBoolean());

  }
}

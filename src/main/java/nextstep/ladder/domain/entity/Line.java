package nextstep.ladder.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

  private static final int ONE = 1;
  private static final Boolean FALSE = false;

  private final List<Point> points = new ArrayList<>();

  public Line(int countOfPerson, BuildStrategy buildStrategy) {
    initPoints();
    IntStream.range(ONE, countOfPerson)
             .forEach(index -> makePointRandomly(index, buildStrategy));
  }

  public Stream<Point> stream() {
    return points.stream();
  }

  private void initPoints() {
    points.add(new Point(FALSE));
  }

  private void makePointRandomly(int number, BuildStrategy buildStrategy) {
    int prevPoint = number - ONE;
    if (points.get(prevPoint).hasWay()) {
      points.add(new Point(FALSE));
      return;
    }

    boolean randomValue = buildStrategy.buildAble();
    points.add(new Point(randomValue));
  }

  public int size() {
    return points.size();
  }
}

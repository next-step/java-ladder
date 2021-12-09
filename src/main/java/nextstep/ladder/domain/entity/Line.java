package nextstep.ladder.domain.entity;

import nextstep.ladder.domain.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

  private static final int ONE = 1;
  private static final Boolean FALSE = false;

  private final List<Point> points = new ArrayList<>();

  public Line(int countOfPerson) {
    initPoints();
    IntStream.range(ONE, countOfPerson)
             .forEach(this::makePointRandomly);
  }

  public Stream<Point> stream() {
    return points.stream();
  }

  private void initPoints() {
    points.add(new Point(FALSE));
  }

  private void makePointRandomly(int number) {
    int prevPoint = number - ONE;
    if (points.get(prevPoint).hasWay()) {
      points.add(new Point(FALSE));
      return;
    }

    boolean randomValue = RandomUtils.getBooleanRandomly();
    points.add(new Point(randomValue));
  }

  public int size() {
    return points.size();
  }
}

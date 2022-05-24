package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Line {

  private static final Random RANDOM = new Random();

  private final List<Boolean> points;

  public Line(int countOfPerson) {
    this(points(countOfPerson));
  }

  public Line(List<Boolean> points) {
    this.points = points;
  }

  private static List<Boolean> points(int countOfPerson) {
    List<Boolean> points = new ArrayList<>();
    points.add(randomPoint());
    for (int i = 1; i < countOfPerson - 1; i++) {
      points.add(point(points.get(i - 1), randomPoint()));
    }
    return points;
  }

  private static Boolean point(boolean prev, boolean current) {
    if (prev == current) {
      return false;
    }
    return current;
  }

  private static Boolean randomPoint() {
    return RANDOM.nextBoolean();
  }

  public List<Boolean> points() {
    return Collections.unmodifiableList(points);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Line line = (Line) o;
    return Objects.equals(points, line.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(points);
  }
}

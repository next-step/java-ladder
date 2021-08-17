package ladderGame.step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

  private static final int INDEX_START = 1;

  private static Random random = new Random();

  private List<Boolean> points;

  public Line(final int countOfPerson) {
    this.points = Collections.unmodifiableList(createLine(countOfPerson));
  }

  public List<Boolean> getPoints() {
    return points;
  }

  public static List<Boolean> createLine(final int countOfPerson) {

    List<Boolean> lines = new ArrayList<>();

    lines.add(false);

    IntStream.range(INDEX_START, countOfPerson)
        .forEach(person -> lines.add(isHaveNode(lines.get(person - INDEX_START))));

    return lines;
  }

  private static Boolean isHaveNode(final Boolean afterNode) {

    if (afterNode) {
      return false;
    }
    return random.nextBoolean();

  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Line line = (Line) o;
    return Objects.equals(points, line.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(points);
  }
}
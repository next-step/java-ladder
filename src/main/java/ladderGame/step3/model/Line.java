package ladderGame.step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import ladderGame.step3.util.RandomMove;

public class Line {

  public static final String MSG_ERROR_LIMIT_COUNT = "최소 1명이상의 플래이어를 입력해주세요.";

  private static final int START_INDEX = 1;

  private final List<Point> points;

  public Line(final List<Point> points) {
    this.points = Collections.unmodifiableList(points);
  }

  public static List<Point> createLine(final int count) {

    validationCount(count);

    List<Point> newPoints = new ArrayList<>();

    Point point = Point.first(RandomMove.createRandomMoveValue());

    newPoints.add(point);

    int lastCount = count - START_INDEX;

    IntStream.range(START_INDEX, lastCount)
        .mapToObj(i -> point.next(i, RandomMove.createRandomMoveValue()))
        .forEach(newPoints::add);

    newPoints.add(point.last(lastCount, RandomMove.createRandomMoveValue()));

    return newPoints;
  }

  private static void validationCount(final int count) {
    if (count < START_INDEX) {
      throw new IllegalArgumentException(MSG_ERROR_LIMIT_COUNT);
    }
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

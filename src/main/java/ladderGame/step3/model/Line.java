package ladderGame.step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladderGame.step3.util.RandomMove;

public class Line {

  public static final String MSG_ERROR_LIMIT_COUNT = "최소 1명이상의 플래이어를 입력해주세요.";

  private static final int POINTS_START_INDEX = 0;

  private static final int START_INT_STREAM_INDEX = 1;

  private static final int POINTS_END_REMAIN_INDEX = 2;

  private final List<Point> points;

  public Line(final List<Point> points) {
    this.points = Collections.unmodifiableList(points);
  }

  public static List<Point> createLine(final int count) {

    validationCount(count);

    List<Point> newPoints = new ArrayList<>();

    newPoints.add(
        new Point(POINTS_START_INDEX, Location.first(RandomMove.createRandomMoveValue())));

    initMiddlePoints(count, newPoints);

    int lastIndex = count - POINTS_END_REMAIN_INDEX;
    newPoints.add(new Point(count - START_INT_STREAM_INDEX, newPoints.get(lastIndex).lastLocation()));

    return newPoints;
  }
  
  private static void validationCount(final int count) {
    if (count < START_INT_STREAM_INDEX) {
      throw new IllegalArgumentException(MSG_ERROR_LIMIT_COUNT);
    }
  }

  public List<Boolean> lineValues() {
    return points.stream()
        .map(Point::pointValue)
        .collect(Collectors.toList());
  }

  public int pointMove(final int userIndex) {
    return points.get(userIndex).move();
  }

  private static void initMiddlePoints(final int count, final List<Point> newPoints) {
    IntStream.range(START_INT_STREAM_INDEX, count - START_INT_STREAM_INDEX)
        .forEach(i -> newPoints.add(new Point(i, newPoints.get(i - START_INT_STREAM_INDEX)
            .nextLocation(RandomMove.createRandomMoveValue()))));
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

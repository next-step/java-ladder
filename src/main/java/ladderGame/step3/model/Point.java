package ladderGame.step3.model;

import java.util.Objects;

public class Point {

  public static final String MSG_ERROR_LIMIT_MIN_VALUE = "시작값은 0보자 작을 수 없습니다.";

  public static final String MSG_ERROR_INVALID_MOVE = "할 수 없는 움직임 입니다.";

  private static final int LIMIT_INDEX_START = 0;

  private final int currentPoint;

  private final Location location;

  public Point(final int point, final Location location) {
    validationPoint(point);
    this.currentPoint = point;
    this.location = location;
  }

  private void validationPoint(final int point) {
    if (point < LIMIT_INDEX_START) {
      throw new IllegalArgumentException(MSG_ERROR_LIMIT_MIN_VALUE);
    }
  }

  public static Point first(final boolean randomMoveValue) {
    return new Point(LIMIT_INDEX_START, Location.first(randomMoveValue));
  }

  public Point next(final int count, final boolean randomMoveValue) {
    return new Point(count, this.location.next(randomMoveValue));
  }

  public Point last(final int count, final boolean randomMoveValue) {
    return new Point(count, this.location.next(randomMoveValue).last());
  }

  public int move() {
    if (this.currentPoint == LIMIT_INDEX_START &&
        this.location.movement().equals(Direction.BACK)) {
      throw new IllegalArgumentException(MSG_ERROR_INVALID_MOVE);
    }
    return this.currentPoint + this.location.point(location.movement());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Point point = (Point) o;
    return currentPoint == point.currentPoint && Objects.equals(location, point.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPoint, location);
  }
}

package nextstep.laddergame.domain;

import java.util.Objects;

public class Point {

  private final int position;
  private final Direction direction;

  public Point(int position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  public static Point first(Boolean right) {
    return new Point(0, Direction.first(right));
  }

  public Point last() {
    return new Point(position + 1, direction.last());
  }

  public Boolean hasRight() {
    return direction.isRight();
  }

  public Boolean hasLeft() {
    return direction.isLeft();
  }


  public int move() {
    if(direction.isRight())
      return position + 1;
    if(direction.isLeft())
      return position - 1;
    return position;
  }

  public Point next(Boolean right) {
    return new Point(position + 1, direction.next(right));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Point)) {
      return false;
    }
    Point point = (Point) o;
    return position == point.position && Objects.equals(direction, point.direction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, direction);
  }

  @Override
  public String toString() {
    return "Point{" +
        "position=" + position +
        ", direction=" + direction +
        '}';
  }
}

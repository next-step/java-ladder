package nextstep.ladder.biz;

public class Point {

  private final int index;
  private final Direction direction;

  private Point(int index, Direction direction) {
    this.index = index;
    this.direction = direction;
  }

  public int move() {
    if (direction.isRight()) {
      return index + 1;
    }

    if (direction.isLeft()) {
      return index - 1;
    }

    return this.index;
  }

  // Add ME
  public boolean hasPoint() {
    return direction.isRight();
  }

  public Point next() {
    return new Point(index + 1, direction.next());
  }

  public Point next(boolean nextRight) {
    return new Point(index + 1, direction.next(nextRight));
  }

  public Point last() {
    return new Point(index + 1, direction.last());
  }

  public static Point first(boolean right) {
    return new Point(0, Direction.first(right));
  }

  @Override
  public String toString() {
    return "PointDirection{" +
            "index=" + index +
            ", direction=" + direction +
            '}';
  }
}

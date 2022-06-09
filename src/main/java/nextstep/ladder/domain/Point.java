package nextstep.ladder.domain;

public class Point {

  private static final int ONE_DIFF = 1;

  private final int index;
  private final Direction direction;

  public Point(int index, Direction direction) {
    this.index = index;
    this.direction = direction;
  }

  public static Point first(boolean right) {
    return new Point(0, Direction.first(right));
  }

  public Point last() {
    return new Point(index + ONE_DIFF, direction.last());
  }

  public Point next() {
    return new Point(index + ONE_DIFF, direction.next());
  }

  public Point next(boolean right) {
    return new Point(index + ONE_DIFF, direction.next(right));
  }

  public int move() {
    if (direction.isLeft()) {
      return index - ONE_DIFF;
    }
    if (direction.isRight()) {
      return index + ONE_DIFF;
    }
    return index;
  }

  public boolean isRight() {
    return direction.isRight();
  }

  public boolean isLeft() {
    return direction.isLeft();
  }
}

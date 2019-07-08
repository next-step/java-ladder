package ladder.domain;

public class Point {

  private final static int START_INDEX = 0;
  private final static int INCREMENT_INDEX = 1;

  private final int index;
  private Direction direction;

  private Point(int index, Direction direction) {
    this.index = index;
    this.direction = direction;
  }

  public static Point first(boolean current) {
    return new Point(START_INDEX, Direction.first(current));
  }

  public Point next(boolean current) {
    return new Point(index + INCREMENT_INDEX, direction.next(current));
  }

  public Point last() {
    return new Point(index + INCREMENT_INDEX, direction.last());
  }

  boolean isCurrent() {
    return direction.isRight();
  }

  int move() {
    if (direction.isLeft()) {
      return index - 1;
    }
    if (direction.isRight()) {
      return index + 1;
    }
    return index;
  }
}

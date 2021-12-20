package nextstep.ladder.domain.entity;

public class Point {

  private static final int LEFT = -1;
  private static final int RIGHT = 1;
  private static final int NOW = 0;

  private final Direction direction;

  public Point(Direction direction) {
    this.direction = direction;
  }

  public static Point first(boolean right) {
    return new Point(Direction.first(right));
  }

  public Point last() {
    return new Point(this.direction.last());
  }

  public boolean hasRightWay() {
    return direction.isRight();
  }

  public int move() {
    if (direction.isLeft()) {
      return LEFT;
    }

    if(direction.isRight()) {
      return RIGHT;
    }

    return NOW;
  }

  public Point next(boolean right) {
    return new Point(direction.next(right));
  }
}

package nextstep.ladder.domain.entity;

public class Point {

  private static final int LEFT = -1;
  private static final int RIGHT = 1;
  private static final int NOW = 0;

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
    return new Point(this.index + RIGHT, this.direction.last());
  }

  public boolean hasRightWay() {
    return direction.isRight();
  }

  public int move() {
    if (direction.isLeft()) {
      return index + LEFT;
    }

    if(direction.isRight()) {
      return index + RIGHT;
    }

    return index + NOW;
  }

  public Point next(boolean right) {
    return new Point(this.index + RIGHT, direction.next(right));
  }

  public boolean isSame(int value) {
    return this.index == value;
  }

}

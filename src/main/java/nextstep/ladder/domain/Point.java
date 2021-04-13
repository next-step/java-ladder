package nextstep.ladder.domain;

import nextstep.ladder.DirectionStrategy;

public class Point {

  public static final int MOVE_LENGTH = 1;
  private final int index;
  private final Direction direction;

  public Point(int index, Direction direction) {
    this.index = index;
    this.direction = direction;
  }

  public static Point first(DirectionStrategy directionStrategy) {
    return new Point(0, Direction.first(directionStrategy));
  }

  public Point next(DirectionStrategy directionStrategy) {
    return new Point(index + 1, direction.next(directionStrategy));
  }

  public Point last() {
    return new Point(index + 1, direction.last());
  }

  public int move() {
    if (direction.isLeft()) {
      return index - MOVE_LENGTH;
    }
    if (direction.isRight()) {
      return index + MOVE_LENGTH;
    }
    return index;
  }

  public boolean isLeft() {
    return direction.isLeft();
  }
}

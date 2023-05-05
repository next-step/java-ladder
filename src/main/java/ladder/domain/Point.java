package ladder.domain;

import ladder.strategy.MoveStrategy;

public class Point {

  private final Position position;
  private final Direction direction;

  private Point(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  public static Point createFirstPoint(MoveStrategy moveStrategy) {
    return new Point(Position.firstPosition(), Direction.firstDirectionOfPoint(moveStrategy));
  }

  public int currentUserPosition() {
    return position.currentPosition();
  }

  public boolean canMoveNext() {
    return direction.canMoveNext();
  }

  public boolean canMovePrevious() {
    return direction.canMovePrevious();
  }

  public Point createNextPoint(MoveStrategy moveStrategy) {
    return new Point(position.moveNext(), direction.nextDirectionOfPoint(moveStrategy));
  }

  public Point createLastPoint() {
    return new Point(position.moveNext(), direction.lastDirectionOfPoint());
  }
}

package ladder.domain;

public class Point {

  private final Position position;
  private final Direction direction;

  public Point(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  public Position move() {
    if (direction.isRight()) {
      return position.rightMove();
    }

    if (direction.isLeft()) {
      return position.leftMove();
    }

    return position;
  }

  public Point next() {
    return new Point(position.rightMove(), direction.next());
  }

  public Point next(Boolean right) {
    return new Point(position.rightMove(), direction.next(right));
  }

  public Point last() {
    return new Point(position.rightMove(), direction.last());
  }

  public static Point first(Boolean right) {
    return new Point(new Position(0), Direction.first(right));
  }

  public boolean isDirectionRight() {
    return direction.isRight();
  }

  @Override
  public String toString() {
    return "Point{" +
        "position=" + position +
        ", direction=" + direction +
        '}';
  }

}

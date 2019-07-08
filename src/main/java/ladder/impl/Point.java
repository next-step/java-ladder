package ladder.impl;

public class Point {

  private Direction direction;
  private Position position;

  private Point(Position position, Direction direction) {
    this.direction = direction;
    this.position = position;
  }

  public static Point first() {
    return of(new Position(0), Direction.first());
  }

  public static Point of(int position, Direction direction) {
    return of(new Position(position),direction);
  }

  public static Point of(Position position, Direction direction) {
    return new Point(position, direction);
  }

  public Point last(int lastPosition) {
    return new Point(new Position(lastPosition), direction.last());
  }

  public Point next() {
    return new Point(position.increment(), direction.next());
  }

  public Position move() {
    return direction.move(position);
  }

  public Position position() {
    return position;
  }

  public Direction direction() {
    return direction;
  }

  @Override
  public String toString() {
    return direction.toString();
  }
}

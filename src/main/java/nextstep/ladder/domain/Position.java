package nextstep.ladder.domain;

public class Position {

  private int position;
  private final Point point;

  public static Position of(int position, Point point) {
    return new Position(position, point);
  }

  private Position(int position, Point point) {
    this.position = position;
    this.point = point;
  }

  public int move(int startPoint) {
    Direction direction = point.move();
    if (direction.right()) {
      return startPoint + 1;
    } else if (direction.left()) {
      return startPoint - 1;
    }
    return startPoint;
  }

}

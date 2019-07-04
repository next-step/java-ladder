package ladder;

public class Point {

  private Direction direction;

  public Point(Direction direction) {
    this.direction = direction;
  }

  public boolean hasLine() {
    return direction.hasLine();
  }

}

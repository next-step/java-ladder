package ladder;

public class Point {

  private Direction direction;

  public Point(Direction direction) {
    this.direction = direction;
  }

  public boolean hasLine() {
    return direction.hasLine();
  }

  public String draw() {
    return direction.draw();
  }

  public int move(int position) {
    return direction.move(position);
  }

}

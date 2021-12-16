package nextstep.ladder.domain.entity;

public class Point {

  private static final Boolean FALSE = false;
  private static final int LEFT = -1;
  private static final int RIGHT = 1;
  private static final int NOW = 0;

  private boolean way;

  public Point(boolean value) {
    this.way = value;
  }

  public Point() {}

  public boolean hasWay() {
    return this.way;
  }

  public Point next(boolean next) {
    if (way && next) {
      return new Point(FALSE);
    }
    return new Point(next);
  }

  public int findDirection(Point left) {
    if (left.hasWay()) {
      return LEFT;
    }

    if(this.hasWay()) {
      return RIGHT;
    }

    return NOW;
  }

}

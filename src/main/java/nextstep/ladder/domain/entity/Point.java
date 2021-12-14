package nextstep.ladder.domain.entity;

public class Point {

  private static final Boolean FALSE = false;

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

}

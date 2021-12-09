package nextstep.ladder.domain.entity;

public class Point {

  public final boolean way;

  public Point(boolean value) {
    this.way = value;
  }

  public boolean hasWay() {
    return this.way;
  }

}

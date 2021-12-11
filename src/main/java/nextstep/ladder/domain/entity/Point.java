package nextstep.ladder.domain.entity;

public class Point {

  private boolean way;

  public Point(BuildStrategy buildStrategy) {
    this(buildStrategy.buildAble());
  }

  public Point(boolean value) {
    this.way = value;
  }

  public Point() {}

  public boolean hasWay() {
    return this.way;
  }

}

package nextstep.ladder.domain;

public class Point {
  private final boolean hasLine;

  public Point(boolean hasLine) {
    this.hasLine = hasLine;
  }

  public boolean hasLine() {
    return hasLine;
  }
}

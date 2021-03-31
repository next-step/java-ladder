package ladder.domain;

import java.util.Objects;

public class Point {

  private final boolean point;

  public Point(boolean point) {
    this.point = point;
  }

  public boolean isUsed() {
    return point;
  }
}

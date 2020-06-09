package laddergame.model;

import java.util.concurrent.ThreadLocalRandom;

public class Point {

  private final boolean rungCreated;

  public Point(boolean rungCreated) {
    this.rungCreated = rungCreated;
  }

  public static Point createNonDuplicatedRungWith(Point target) {
    if (target.isRungCreated()) {
      return new Point(false);
    }
    return new Point(ThreadLocalRandom.current().nextBoolean());
  }

  public boolean isRungCreated() {
    return rungCreated;
  }

  @Override
  public String toString() {
    return "Point{" +
        "rungCreated=" + rungCreated +
        '}';
  }
}

package laddergame.model;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Point {

  private static final String RUNG_EXIST = "-----|";
  private static final String RUNG_NOT_EXIST = "     |";

  private boolean rungCreated;

  private int position;
  private Point linkedPoint;


  public Point(boolean rungCreated) {
    this.rungCreated = rungCreated;
  }
  
  //TODO : 빌더
  public Point(int position) {
    this.position = position;
  }

  public Point(int position, Point linkedPoint) {
    this.position = position;
    this.linkedPoint = linkedPoint;
    linkedPoint.linkedPoint = this.linkedPoint;
  }

  public int getPosition() {
    return position;
  }

  public int getNextPosition() {
    if (linkedPoint != null) {
      return linkedPoint.position;
    }

    return position;
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return rungCreated == point.rungCreated &&
        position == point.position &&
        linkedPoint.equals(point.linkedPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rungCreated, position, linkedPoint);
  }

  @Override
  public String toString() {
    return rungCreated ? RUNG_EXIST : RUNG_NOT_EXIST;
  }

  public boolean hasLinkedPoint() {
    if (linkedPoint != null) {
      return true;
    }

    return false;
  }

  public Point createNext() {
    if (hasLinkedPoint()) {
      return new Point(position + 1);
    }

    return createNextWithLinkedBy(ThreadLocalRandom.current().nextBoolean());
  }

  public Point createNextWithLinkedBy(boolean isLinked) {
    Point next = new Point(position + 1);

    if (isLinked) {
      this.linkedPoint = next;
      next.linkedPoint = this;
    }

    return next;
  }
}

package laddergame.model;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Point {

  private final int position;
  private Point linkedPoint;

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

  public boolean hasLinkedPoint() {
    return linkedPoint != null;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return position == point.position &&
        Objects.equals(linkedPoint, point.linkedPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, linkedPoint);
  }

  @Override
  public String toString() {
    return "Point{" +
        "position=" + position +
        ", linkedPoint=" + getNextPosition() +
        '}';
  }
}

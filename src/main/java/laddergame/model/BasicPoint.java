package laddergame.model;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class BasicPoint implements LinkablePoint {

  private final Position position;
  private Point linkedBasicPoint;

  private BasicPoint(Position position) {
    this.position = position;
    linkedBasicPoint = new EmptyPoint(position);
  }

  public static LinkablePoint create(int position) {
    return new BasicPoint(new Position(position));
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public Position getNextPosition() {
    return linkedBasicPoint.getPosition();

  }

  @Override
  public boolean isEmpty() {
    return false;
  }


  @Override
  public LinkablePoint createNext() {
    if (linkedBasicPoint.isEmpty()) {
      return createNextWithLinkedBy(ThreadLocalRandom.current().nextBoolean());
    }

    return BasicPoint.create(position.getValue() + 1);
  }

  @Override
  public LinkablePoint createNextWithLinkedBy(boolean isLinked) {
    BasicPoint next = new BasicPoint(new Position(position.getValue() + 1));

    if (isLinked) {
      this.linkedBasicPoint = next;
      next.linkedBasicPoint = this;
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
    BasicPoint basicPoint = (BasicPoint) o;
    return position == basicPoint.position &&
        Objects.equals(linkedBasicPoint, basicPoint.linkedBasicPoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position, linkedBasicPoint);
  }

  @Override
  public String toString() {
    return "Point{" +
        "position=" + position +
        ", linkedPoint=" + getNextPosition() +
        '}';
  }
}

package ladder.domain;

import ladder.domain.movestrategy.MoveStrategy;

import java.util.Objects;

public class Point {
  private final Coordinates coordinates;
  private final Sides sides;
  private final MoveStrategy moveStrategy;

  public static Point first(final int y, final Boolean right, MoveStrategy moveStrategy) {
    return new Point(Coordinates.of(0, y), Sides.first(right), moveStrategy);
  }

  public Point next(final Boolean right, MoveStrategy moveStrategy) {
    return new Point(this.coordinates.right(), this.sides.next(right), moveStrategy);
  }

  public Point last(MoveStrategy moveStrategy) {
    return new Point(this.coordinates.right(), this.sides.last(), moveStrategy);
  }

  private Point(final Coordinates coordinates, final Sides sides, MoveStrategy moveStrategy) {
    this.coordinates = coordinates;
    this.sides = sides;
    this.moveStrategy = moveStrategy;
  }

  public Coordinates move() {
    if (Direction.RIGHT.equals(sides.direction(moveStrategy))) {
      return this.coordinates.downRight();
    }

    if (Direction.LEFT.equals(sides.direction(moveStrategy))) {
      return this.coordinates.downLeft();
    }

    return this.coordinates.downStraight();
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
    return coordinates.equals(point.coordinates) && sides.equals(point.sides);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coordinates, sides);
  }
}

package ladder.domain.ladder;

import java.util.Objects;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Point {

  private final int index;
  private final Direction direction;

  private Point(int index, Direction direction) {
    this.index = index;
    this.direction = direction;
  }

  public static Point of(int index, boolean left, boolean current) {
    return new Point(index, Direction.of(left, current));
  }

  public static Point first(NextPointGenerationStrategy strategy){
    return new Point(0, Direction.first(strategy));
  }

  public Point next(NextPointGenerationStrategy strategy){
    return new Point(index + 1, direction.next(strategy));
  }

  public int move(){
    return index + direction.move();
  }

  public boolean untilBeforeLastIndexOfPoint(int numberOfParticipants) {
    return index < numberOfParticipants - 2;
  }

  public Point last() {
    return new Point(index + 1, direction.last());
  }


  public boolean isContinuous(Point point) {
    return this.direction.isContinuous(point.direction);
  }

  public Direction getDirection() {
    return direction;
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
    return index == point.index && Objects.equals(direction, point.direction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, direction);
  }
}

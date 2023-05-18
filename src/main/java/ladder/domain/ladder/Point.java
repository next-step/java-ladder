package ladder.domain.ladder;

import ladder.domain.strategy.NextPointGenerationStrategy;

public class Point {

  private final int index;
  private final Direction direction;

  private Point(int index, Direction direction) {
    this.index = index;
    this.direction = direction;
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

  public boolean untilBeforeLastPoint(int numberOfParticipants) {
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
}

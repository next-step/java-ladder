package ladder.domain.ladder;

import static ladder.domain.ladder.MoveStatus.LEFT;
import static ladder.domain.ladder.MoveStatus.NONE;
import static ladder.domain.ladder.MoveStatus.RIGHT;

import java.util.Objects;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Direction {

  private final boolean left;
  private final boolean current;

  private Direction(boolean left, boolean current) {
    validateDirection(left, current);
    this.left = left;
    this.current = current;
  }

  public static Direction of(boolean left, boolean current) {
    return new Direction(left, current);
  }

  public static Direction first(NextPointGenerationStrategy strategy) {
   return of(false, strategy.nextBoolean(false));
  }

  public Direction last() {
    return of(this.current, false);
  }

  public static Direction last(boolean left) {
    return of(left, false);
  }

  private void validateDirection(boolean left, boolean current) {
    if (isBothTrue(left, current)) {
      throw new IllegalArgumentException("왼쪽과 오른쪽 방향이 모두 true일 수 없습니다.");
    }
  }

  private boolean isBothTrue(boolean left, boolean current) {
    return left && current;
  }

  public boolean left() {
    return left;
  }

  public boolean current() {
    return current;
  }

  public int move() {
    if (this.left) {
      return LEFT.value();
    }
    if (this.current) {
      return RIGHT.value();
    }
    return NONE.value();
  }

  public Direction next(NextPointGenerationStrategy strategy) {
    return of(current, strategy.nextBoolean(current));
  }

  public boolean isContinuous(Direction direction) {
    return isBothTrue(this.current, direction.current);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Direction direction = (Direction) o;
    return left == direction.left && current == direction.current;
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, current);
  }
}

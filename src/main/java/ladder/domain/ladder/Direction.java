package ladder.domain.ladder;

import static ladder.domain.ladder.MoveStatus.LEFT;
import static ladder.domain.ladder.MoveStatus.NONE;
import static ladder.domain.ladder.MoveStatus.RIGHT;

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

  public static Direction first(boolean current) {
   return of(false, current);
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

  public MoveStatus move() {
    if (left) {
      return LEFT;
    }
    if (current) {
      return RIGHT;
    }
    return NONE;
  }
}

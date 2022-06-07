package nextstep.ladder.domain;

import static nextstep.ladder.util.LadderPointGenerator.generateByHalfRate;

import java.util.Objects;

public class Direction {

  private final boolean left;
  private final boolean right;

  public Direction(boolean left, boolean right) {
    if (left && right) {
      throw new IllegalStateException("가로선은 연속될 수 없습니다.");
    }
    this.left = left;
    this.right = right;
  }

  public static Direction of(boolean left, boolean right) {
    return new Direction(left, right);
  }

  public static Direction first(boolean right) {
    return of(false, right);
  }

  public Direction last() {
    return of(this.right, false);
  }

  public Direction next(boolean right) {
    return of(this.right, right);
  }

  public Direction next() {
    if (this.right) {
      return next(false);
    }
    return next(generateByHalfRate());
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
    return left == direction.left && right == direction.right;
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }
}

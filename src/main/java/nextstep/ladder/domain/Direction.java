package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.DirectionStrategy;

public class Direction {

  private boolean left;
  private boolean right;

  private Direction(boolean left, boolean right) {
    if (left && right) {
      throw new IllegalArgumentException("Neither can be true.");
    }
    this.left = left;
    this.right = right;
  }

  public static Direction of(boolean left, boolean right) {
    return new Direction(left, right);
  }

  public static Direction first(DirectionStrategy directionStrategy) {
    return new Direction(false, directionStrategy.isRight());
  }

  public Direction next(DirectionStrategy directionStrategy) {
    if (right) {
      return new Direction(true, false);
    }
    return new Direction(false, directionStrategy.isRight());
  }

  public Direction last() {
    return new Direction(right, false);
  }

  public boolean isLeft() {
    return left;
  }

  public boolean isRight() {
    return right;
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

  @Override
  public String toString() {
    return "Direction{" +
        "left=" + left +
        ", right=" + right +
        '}';
  }
}

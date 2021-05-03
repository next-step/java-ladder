package nextstep.laddergame.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static nextstep.laddergame.domain.utils.RandomValueGenerator.generate;

public class Direction {

  private final boolean left;
  private final boolean right;

  private Direction(boolean left, boolean right) {
    validate(left, right);
    this.left = left;
    this.right = right;
  }

  private void validate(boolean left, boolean right) {
    if(left && right) {
      throw new IllegalStateException("ERROR : 왼쪽과 오른쪽 둘 다 true 일 수 없습니다.");
    }
  }

  public Direction next(boolean nextRight) {
    return of(this.right, nextRight);
  }

  public Direction next() {
    if(this.right) {
      return next(FALSE);
    }
    return next(generate());
  }

  public static Direction first(boolean right) {
    return Direction.of(FALSE, right);
  }

  public Direction last() {
    return Direction.of(this.right, false);
  }

  public static Direction of(boolean first, boolean second) {
    return new Direction(first, second);
  }

  public boolean isRight() {
    return this.right;
  }

  public boolean isLeft() {
    return this.left;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Direction)) {
      return false;
    }
    Direction direction = (Direction) o;
    return isLeft() == direction.isLeft() && isRight() == direction.isRight();
  }

  @Override
  public int hashCode() {
    return Objects.hash(isLeft(), isRight());
  }

  @Override
  public String toString() {
    return "Direction{" +
        "left=" + left +
        ", right=" + right +
        '}';
  }
}

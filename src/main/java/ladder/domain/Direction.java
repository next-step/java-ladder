package ladder.domain;

import static java.lang.Boolean.FALSE;

import java.util.Objects;
import ladder.domain.generator.Generator;
import ladder.domain.generator.PointsGenerator;

public class Direction {
  private final boolean left;
  private final boolean right;
  private static final String INVALID_DIRECTION = "유효하지 않은 방향입니다.";

  private Direction(boolean left, boolean right) {
    if (left && right) {
      throw new IllegalArgumentException(INVALID_DIRECTION);
    }

    this.left = left;
    this.right = right;
  }

  public boolean isRight() {
    return this.right;
  }

  public boolean isLeft() {
    return this.left;
  }

  public Direction next(boolean nextRight) {
    return of(this.right, nextRight);
  }

  public Direction next() {
    Generator generator = new PointsGenerator();
    if (this.right) {
      return next(FALSE);
    }

    return next(generator.generatePoint());
  }

  public static Direction of(boolean first, boolean second) {
    return new Direction(first, second);
  }

  public static Direction first(boolean right) {
    return of(FALSE, right);
  }

  public Direction last() {
    return of(this.right, FALSE);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Direction pair = (Direction) o;
    return left == pair.left &&
        right == pair.right;
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

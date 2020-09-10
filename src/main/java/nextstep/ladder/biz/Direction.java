package nextstep.ladder.biz;

import java.util.Objects;

public class Direction {

  private boolean left;
  private boolean right;

  private Direction(boolean left, boolean right) {
    if (left && right) throw new IllegalStateException("한쪽 방향으로만 갈 수 있습니다.");

    this.left = left;
    this.right = right;
  }

  public boolean isLeft() {
    return this.left;
  }

  public boolean isRight() {
    return this.right;
  }

  public Direction next() {
    return of(right, !right);
  }

  public Direction next(boolean nextRight) {
    return of(this.right, nextRight);
  }

  public static Direction first(boolean right) {
    return of(false, right);
  }

  public Direction last() {
    return of(this.right, false);
  }

  public static Direction of(boolean left, boolean right) {
    return new Direction(left, right);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Direction direction = (Direction) o;
    return left == direction.left && right == direction.right;
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }

  @Override
  public String toString() {
    return "Direction{" + "left=" + left + ", right=" + right + '}';
  }
}

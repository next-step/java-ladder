package ladder.domain;

import ladder.domain.movestrategy.MoveStrategy;

import java.util.Objects;

public class Sides {
  private final Boolean left;
  private final Boolean right;

  public static Sides first(final Boolean right) {
    return new Sides(false, right);
  }

  public Sides next(final Boolean right) {
    return new Sides(this.right, right);
  }

  public Sides last() {
    return new Sides(this.right, false);
  }

  private Sides(final Boolean left, final Boolean right) {
    if (left && right) {
      throw new IllegalStateException("양 쪽 모두 선이 있을 수 없습니다.");
    }

    this.left = left;
    this.right = right;
  }

  public Direction direction(MoveStrategy moveStrategy) {
    return moveStrategy.move(this);
  }

  public Boolean right() {
    return this.right;
  }

  public Boolean left() {
    return this.left;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Sides sides = (Sides) o;
    return left.equals(sides.left) && right.equals(sides.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }

  @Override
  public String toString() {
    return "Sides{" +
            "left=" + left +
            ", right=" + right +
            '}';
  }
}

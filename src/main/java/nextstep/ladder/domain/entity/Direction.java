package nextstep.ladder.domain.entity;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Direction {

  private final boolean left;
  private final boolean right;

  public Direction(boolean left, boolean right) {
    if (left && right) {
      throw new IllegalStateException();
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
    if (this.right) {
      return of(TRUE, FALSE);
    }

    return of(FALSE, nextRight);
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


}

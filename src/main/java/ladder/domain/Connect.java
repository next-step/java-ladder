package ladder.domain;

import java.security.InvalidParameterException;
import java.util.function.UnaryOperator;

public enum Connect {
  NONE(false, false, (x) -> x),
  LEFT(true, false, (x) -> x - 1),
  RIGHT(false, true, (x) -> x + 1);

  private final UnaryOperator<Integer> nextPositionFunc;
  private final boolean left;
  private final boolean right;

  Connect(boolean left, boolean right, UnaryOperator<Integer> nextPositionFunc) {
    this.left = left;
    this.right = right;
    this.nextPositionFunc = nextPositionFunc;
  }

  public static Connect of(boolean left, boolean right) {
    return getConnect(left, right);
  }

  public static Connect first(boolean right) {
    return getConnect(false, right);
  }

  public Connect last() {
    return getConnect(this.right, false);
  }

  private static Connect getConnect(boolean left, boolean right) {
    if (!left && !right) {
      return NONE;
    }
    if (left && !right) {
      return LEFT;
    }
    if (!left && right) {
      return RIGHT;
    }
    throw new InvalidParameterException("잘못된 연결입니다.");
  }

  public int move(int index) {
    return nextPositionFunc.apply(index);
  }

  public Connect generateNext(boolean connect) {
    if (this.right) {
      return Connect.getConnect(true, false);
    }
    return Connect.getConnect(false, connect);
  }

}

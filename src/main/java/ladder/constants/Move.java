package ladder.constants;

import ladder.exception.InvalidDirectionException;

import java.util.Arrays;

public enum Move {
  RIGHT(1, true, false),
  LEFT(-1, false, true),
  STAY(0);

  private final int value;
  private final boolean right;
  private final boolean left;

  Move(int value) {
    this(value, false, false);
  }

  Move(int value, boolean right, boolean left) {
    this.value = value;
    this.right = right;
    this.left = left;
  }

  public static Move valueOf(boolean right, boolean left) {
    return Arrays.stream(Move.values())
            .filter(move -> move.right == right && move.left == left)
            .findFirst()
            .orElseThrow(InvalidDirectionException::new);
  }

  public int forward(int value) {
    return value + this.value;
  }


  public int getValue() {
    return value;
  }
}

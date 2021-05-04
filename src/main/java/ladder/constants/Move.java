package ladder.constants;

public enum Move {
  RIGHT(1),
  LEFT(-1);

  private final int value;

  Move(int value) {
    this.value = value;
  }

  public int forward(int value) {
    return value + this.value;
  }

  public int getValue() {
    return value;
  }
}

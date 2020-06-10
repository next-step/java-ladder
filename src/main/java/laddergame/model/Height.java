package laddergame.model;

public class Height {

  private final int value;

  public Height(int value) {
    if (value <= 0) {
      throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
    }

    this.value = value;
  }

  public int getValue() {
    return value;
  }
}

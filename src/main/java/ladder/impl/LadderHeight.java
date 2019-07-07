package ladder.impl;

import java.util.Objects;

public class LadderHeight {

  private int height;

  public LadderHeight(int height) {
    this.height = height;
  }

  public static LadderHeight of(int height) {
    if (height < 1) {
      throw new IllegalArgumentException("높이는 0보다 커야합니다.");
    }
    return new LadderHeight(height);
  }

  public int value() {
    return height;
  }

  @Override
  public String toString() {
    return "LadderHeight{" +
        "height=" + height +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LadderHeight that = (LadderHeight) o;
    return height == that.height;
  }

  @Override
  public int hashCode() {
    return Objects.hash(height);
  }
}

package ladder.model;

import ladder.error.InvalidHeightException;

import java.util.Objects;

public class Height {
  private static final String MINIMUM_HEIGHT_EXCEPTION_MESSAGE = "최소 높이보다 낮습니다.";
  private static final int MINIMUM_HEIGHT_LIMIT = 1;

  private final int height;


  public Height(int height) {
    checkHeight(height);
    this.height = height;
  }

  private void checkHeight(int height) {
    if (height < MINIMUM_HEIGHT_LIMIT) {
      throw new InvalidHeightException(MINIMUM_HEIGHT_EXCEPTION_MESSAGE);
    }
  }

  public int height() {
    return height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Height height1 = (Height) o;
    return height == height1.height;
  }

  @Override
  public int hashCode() {
    return Objects.hash(height);
  }
}

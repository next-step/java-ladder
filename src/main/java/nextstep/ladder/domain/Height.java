package nextstep.ladder.domain;

import static java.lang.Integer.parseInt;

import java.util.Objects;

public class Height {

  private final int height;

  public Height(String height) {
    this(parseInt(height));
  }

  public Height(int height) {
    if (height < 1) {
      throw new IllegalArgumentException("사다리 높이는 1보다 작을 수 없습니다.");
    }
    this.height = height;
  }

  public int height() {
    return height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Height that = (Height) o;
    return height == that.height;
  }

  @Override
  public int hashCode() {
    return Objects.hash(height);
  }
}

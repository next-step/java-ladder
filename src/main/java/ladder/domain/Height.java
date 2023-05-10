package ladder.domain;

public class Height {

  private static final int MIN_HEIGHT = 1;

  private final int height;

  public Height(int height) {
    validateHeight(height);
    this.height = height;
  }

  private void validateHeight(int height) {
    if (isUnderHeight(height)) {
      throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
    }
  }

  private boolean isUnderHeight(int height) {
    return height < MIN_HEIGHT;
  }


}

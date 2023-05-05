package ladder.domain;

public class LadderHeight {

  private static final String ILLEGAL_HEIGHT_MESSAGE = "사다리의 높이는 1이상 이어야 합니다. 현재 사다리 입력 : ";
  private static final int MINIMUM_HEIGHT = 1;
  private final int height;

  public LadderHeight(int height) {
    validateHeight(height);

    this.height = height;
  }

  public int height() {
    return height;
  }

  private void validateHeight(int height) {
    if (height < MINIMUM_HEIGHT) {
      throw new IllegalArgumentException(ILLEGAL_HEIGHT_MESSAGE + height);
    }
  }
}

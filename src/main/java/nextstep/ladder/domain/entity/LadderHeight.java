package nextstep.ladder.domain.entity;

public class LadderHeight {

  private static final String ERROR_SIZE_MESSAGE = "0보다 큰 수를 입력해 주세요";
  private static final int MIN_HEIGHT = 1;

  private final int height;

  public LadderHeight(int height) {
    validSize(height);
    this.height = height;
  }

  private static void validSize(int height) {
    if (height < MIN_HEIGHT) {
      throw new IllegalArgumentException(ERROR_SIZE_MESSAGE);
    }
  }

  public int howTall() {
    return this.height;
  }
}

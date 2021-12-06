package nextstep.ladder.domain.entity;

public class LadderHeight {

  private static final String ERROR_SIZE_MESSAGE = "0보다 큰 수를 입력해 주세요";

  private int length;

  public LadderHeight(int length) {
    validSize(length);
    this.length = length;
  }

  private static void validSize(int length) {
    if (length < 1) {
      throw new IllegalArgumentException(ERROR_SIZE_MESSAGE);
    }
  }

  public int howTall() {
    return this.length;
  }
}

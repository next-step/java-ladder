package ladder.exception;

public class LadderHeightOutOfBoundsException extends IllegalArgumentException {
  public static LadderHeightOutOfBoundsException INSTANCE = new LadderHeightOutOfBoundsException();

  private static final String ERROR_MESSAGE_FORMAT = "사다리의 최소 높이는 %d 입니다.";
  private static final int MIN = 1;

  public LadderHeightOutOfBoundsException() {
    super(String.format(ERROR_MESSAGE_FORMAT, MIN));
  }

  public static void verify(int height) {
    if (MIN > height) {
      throw INSTANCE;
    }
  }
}

package ladder.exception;

public class LadderWidthOutOfBoundsException extends IllegalArgumentException {
  public static final LadderWidthOutOfBoundsException INSTANCE = new LadderWidthOutOfBoundsException();

  private static final String ERROR_MESSAGE_FORMAT = "사다리의 최소 폭은 %d 입니다.";
  private static final int MIN = 1;

  public LadderWidthOutOfBoundsException() {
    super(String.format(ERROR_MESSAGE_FORMAT, MIN));
  }

  public static void verify(int width) {
    if (MIN > width) {
      throw INSTANCE;
    }
  }
}

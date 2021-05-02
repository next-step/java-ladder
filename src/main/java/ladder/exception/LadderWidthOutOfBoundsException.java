package ladder.exception;

public class LadderWidthOutOfBoundsException extends IllegalArgumentException {
  private static final String ERROR_MESSAGE_FORMAT = "사다리의 최소 폭은 %d 입니다.";

  private LadderWidthOutOfBoundsException() {
  }

  public LadderWidthOutOfBoundsException(int min) {
    super(String.format(ERROR_MESSAGE_FORMAT, min));
  }
}

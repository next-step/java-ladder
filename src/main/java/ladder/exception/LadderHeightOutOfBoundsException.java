package ladder.exception;

public class LadderHeightOutOfBoundsException extends IllegalArgumentException {
  private static final String ERROR_MESSAGE_FORMAT = "사다리의 최소 높이는 %d 입니다.";

  private LadderHeightOutOfBoundsException() {

  }

  public LadderHeightOutOfBoundsException(int min) {
    super(String.format(ERROR_MESSAGE_FORMAT, min));
  }
}

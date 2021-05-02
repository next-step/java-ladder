package ladder.exception;

public class DepthLineOutOfBoundsException extends IllegalArgumentException {
  private static final String ERROR_INVALID_LINE_COUNT_FORMAT = "사다리는 최소 %d 라인 갯수가 필요합니다.";

  private DepthLineOutOfBoundsException() {
  }

  public DepthLineOutOfBoundsException(int minOfLine) {
    super(String.format(ERROR_INVALID_LINE_COUNT_FORMAT, minOfLine));
  }
}

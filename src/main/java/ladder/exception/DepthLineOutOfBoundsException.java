package ladder.exception;

public class DepthLineOutOfBoundsException extends IllegalArgumentException {
  public static final DepthLineOutOfBoundsException INSTANCE = new DepthLineOutOfBoundsException();

  private static final String ERROR_INVALID_LINE_COUNT_FORMAT = "최소 그릴 수 있는 라인 갯수(%d)가 아닙니다.";
  private static final int MIN_OF_LINE_COUNT = 1;

  public DepthLineOutOfBoundsException() {
    super(String.format(ERROR_INVALID_LINE_COUNT_FORMAT, MIN_OF_LINE_COUNT));
  }

  public static void verify(int countOfLine) {
    if (MIN_OF_LINE_COUNT > countOfLine) {
      throw INSTANCE;
    }
  }
}

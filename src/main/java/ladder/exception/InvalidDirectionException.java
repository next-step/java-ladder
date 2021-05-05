package ladder.exception;

public class InvalidDirectionException extends IllegalArgumentException {
  private static final String EXCEPTION_MESSAGE = "오른쪽과 왼쪽을 동시에 갈 수 없습니다.";

  public InvalidDirectionException() {
    super(EXCEPTION_MESSAGE);
  }
}

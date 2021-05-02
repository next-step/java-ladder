package ladder.exception;

public class PlayerNameOverLimitLengthException extends IllegalArgumentException {
  private static final String EXCEPTION_MESSAGE = "이름 길이가 %d 초과했습니다.";

  private PlayerNameOverLimitLengthException() {

  }

  public PlayerNameOverLimitLengthException(int max) {
    super(String.format(EXCEPTION_MESSAGE, max));
  }
}

package ladder.exception;

public class PlayerNameOverLimitLengthException extends IllegalArgumentException {
  public static final PlayerNameOverLimitLengthException INSTANCE = new PlayerNameOverLimitLengthException();
  public static final int MAX = 5;

  private static final String EXCEPTION_MESSAGE = "이름 길이가 %d 초과했습니다.";

  private PlayerNameOverLimitLengthException() {
    super(String.format(EXCEPTION_MESSAGE, MAX));
  }

  public static void verify(String name) {
    if (name.length() > MAX) {
      throw INSTANCE;
    }
  }
}

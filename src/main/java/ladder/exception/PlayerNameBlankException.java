package ladder.exception;

public class PlayerNameBlankException extends IllegalArgumentException {
  private static final String EXCEPTION_MESSAGE = "이름은 null 또는 빈 문자열을 입력할 수 없습니다.";

  public PlayerNameBlankException() {
    super(EXCEPTION_MESSAGE);
  }
}

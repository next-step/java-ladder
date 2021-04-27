package ladder.exception;

import ladder.util.StringUtil;

public class PlayerNameBlankException extends IllegalArgumentException {
  public static final PlayerNameBlankException INSTANCE = new PlayerNameBlankException();

  private static final String EXCEPTION_MESSAGE = "이름은 null 또는 빈 문자열을 입력할 수 없습니다.";

  private PlayerNameBlankException() {
    super(EXCEPTION_MESSAGE);
  }

  public static void verify(String name) {
    if (StringUtil.isBlank(name)) {
      throw INSTANCE;
    }
  }
}

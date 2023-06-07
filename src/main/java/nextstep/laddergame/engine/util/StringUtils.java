package nextstep.laddergame.engine.util;

public class StringUtils {

  private StringUtils() {
  }

  public static void checkNullOrBlank(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }
  }
}

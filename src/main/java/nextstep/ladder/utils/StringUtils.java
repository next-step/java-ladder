package nextstep.ladder.utils;

public final class StringUtils {

  private StringUtils() {}

  public static String padLeft(String padString, int size) {
    return String.format("%" + size + "s", padString);
  }
}

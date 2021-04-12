package nextstep.ladder.utils;

public final class StringUtils {

  private StringUtils() {}

  public static String padLeft(String string, int size) {
    return String.format("%" + size + "s", string);
  }
}

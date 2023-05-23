package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {

  private StringUtils() {}

  private static final Pattern NUMERIC_PATTEN = Pattern.compile("-?\\d+");

  public static boolean isNotBlank (String input) {
    return !isBlank(input);
  }

  public static boolean isBlank (String input) {
    return input == null || input.isBlank();
  }

  public static boolean isDigit(String input) {
    Matcher matcher = NUMERIC_PATTEN.matcher(input);
    return matcher.matches();
  }

  public static boolean isNotDigit(String input) {
    return !isDigit(input);
  }
}

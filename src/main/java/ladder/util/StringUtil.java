package ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public final class StringUtil {
  private StringUtil() {
  }

  public static boolean isBlank(String str) {
    return str == null || str.isEmpty();
  }

  public static String generatedRandomString(int targetLength) {
    return new Random().ints('a', 'z' + 1)
            .limit(targetLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
  }

  public static List<String> toList(String str) {
    return toList(str, ",");
  }

  public static List<String> toList(String str, String regex) {
    return Arrays.asList(defaultString(str).split(regex))
            .stream().map(StringUtil::trim)
            .collect(Collectors.toList());
  }

  public static String trim(String str) {
    return defaultString(str).trim();
  }

  public static String defaultString(String str) {
    if (str == null) {
      return "";
    }
    return str;
  }
}

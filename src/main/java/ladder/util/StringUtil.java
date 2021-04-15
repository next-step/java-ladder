package ladder.util;

import java.util.Random;

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
}

package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class Name {
  private static final Map<String, Name> cache = new HashMap<>();

  private final String value;

  public static Name of(final String value) {
    if (cache.containsKey(value)) {
      return cache.get(value);
    }

    return new Name(value);
  }

  private Name(final String value) {
    if (isIllegalName(value)) {
      throw new IllegalArgumentException("유효하지 않은 이름");
    }

    this.value = value;
    cache.put(value, this);
  }

  private boolean isIllegalName(String name) {
    final int MAX_LENGTH = 5;

    if (name.length() > MAX_LENGTH || name.isEmpty()) {
      return true;
    }
    return false;
  }

  public String value() {
    return this.value;
  }
}

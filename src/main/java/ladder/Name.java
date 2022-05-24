package ladder;

import java.util.Objects;

public class Name {

  private static final String EXIT_TRIGGER = "exit";
  private static final String ALL_TRIGGER = "all";
  private static final String MESSAGE_FOR_BLANK = "참가자 이름이 비어있으면 안됩니다.";
  private static final String MESSAGE_FOR_OVER_LENGTH = "참가자 이름은 %s글자 이내여야 합니다.";
  private static final int MAX_NAME_LENGTH = 5;

  public static final Name ALL = new Name(ALL_TRIGGER);
  public static final Name EXIT = new Name(EXIT_TRIGGER);

  private final String name;

  Name(String name) {
    validateName(name);
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name other = (Name) o;
    return Objects.equals(name, other.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  private void validateName(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException(MESSAGE_FOR_BLANK);
    }

    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException(String.format(MESSAGE_FOR_OVER_LENGTH, MAX_NAME_LENGTH));
    }
  }

  public static Name of(String name) {
    if (ALL_TRIGGER.equals(name)) {
      return ALL;
    }

    if (EXIT_TRIGGER.equals(name)) {
      return EXIT;
    }
    return new Name(name);
  }
}

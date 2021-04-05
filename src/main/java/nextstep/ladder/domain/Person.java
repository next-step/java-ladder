package nextstep.ladder.domain;

public class Person {

  private static final int MAX_NAME_LENGTH = 5;
  private String name;

  private Person(String name) {
    this.name = name;
  }

  public static Person generate(String name) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("name length > 5.");
    }

    return new Person(name);
  }

  public String getName() {
    return name;
  }
}

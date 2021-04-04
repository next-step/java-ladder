package nextstep.ladder.domain;

public class Person {

  private static final int MAX_NAME_LENGTH = 5;
  private String name;

  private Person() {
  }

  public static Person create(String name) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("name length > 5.");
    }

    Person person = new Person();
    person.name = name;
    return person;
  }

  public String getName() {
    return name;
  }
}

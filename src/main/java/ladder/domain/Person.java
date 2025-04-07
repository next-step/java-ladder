package ladder.domain;

import java.util.Objects;

public class Person {
  private static final int MAX_NAME_LENGTH = 5;
  private final String name;

  public Person(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("이름은 빈 문자열일 수 없습니다");
    }
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다");
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}

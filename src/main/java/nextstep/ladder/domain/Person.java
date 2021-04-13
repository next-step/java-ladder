package nextstep.ladder.domain;

import java.util.Objects;

public class Person {

  private String name;

  private Person(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("name.length < 6");
    }
    this.name = name;
  }

  public static Person generate(String name) {
    return new Person(name);
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(name, person.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}

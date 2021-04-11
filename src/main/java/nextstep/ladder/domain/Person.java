package nextstep.ladder.domain;

import java.util.Objects;

public final class Person {

  private final Name name;

  private Person(final Name name) {
    this.name = name;
  }

  public static Person valueOf(final String name) {
    return new Person(new Name(name));
  }

  public String personName() {
    return name.getName();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person)) {
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

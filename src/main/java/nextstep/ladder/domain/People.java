package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public final class People {

  private final List<Person> people;

  public People(final List<Person> people) {
    this.people = people;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof People)) {
      return false;
    }
    People people1 = (People) o;
    return Objects.equals(people, people1.people);
  }

  @Override
  public int hashCode() {
    return Objects.hash(people);
  }
}

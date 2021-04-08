package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class People {

  private final List<Person> people;

  public People(final String[] names) {
    this(Arrays.stream(names)
        .map(Person::new)
        .collect(Collectors.toList())
    );
  }

  public People(final List<Person> people) {
    this.people = people;
    validateSize();
  }

  private void validateSize() {
    personCount();
  }

  public PersonCount personCount() {
    return new PersonCount(people.size());
  }

  public List<Person> personList() {
    return Collections.unmodifiableList(people);
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

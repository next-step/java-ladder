package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.exception.PersonCountTooLowException;

public final class People {

  private final List<Person> people;

  private People(final List<Person> people) {
    validateSize(people);
    this.people = people;
  }

  public static People from(final String[] names) {
    return new People(Arrays.stream(names)
        .map(Person::valueOf)
        .collect(Collectors.toList())
    );
  }

  private void validateSize(final List<Person> people) {
    if (people.size() < PersonCount.MIN) {
      throw new PersonCountTooLowException();
    }
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

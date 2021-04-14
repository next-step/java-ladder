package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import nextstep.ladder.exception.PersonCountTooLowException;

public final class People {

  public static final int MINIMUM_PERSON_COUNT = 2;

  private final List<Person> people;

  private People(final List<Person> people) {
    validateSize(people);
    this.people = people;
  }

  public static People from(final String[] names) {
    return Arrays.stream(names)
        .map(Person::valueOf)
        .collect(Collectors.collectingAndThen(Collectors.toList(), People::new));
  }

  private void validateSize(final List<Person> people) {
    if (people.size() < MINIMUM_PERSON_COUNT) {
      throw new PersonCountTooLowException();
    }
  }

  public List<Person> personList() {
    return Collections.unmodifiableList(people);
  }

  public int personCount() {
    return people.size();
  }

  public boolean contains(Person person) {
    return people.contains(person);
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

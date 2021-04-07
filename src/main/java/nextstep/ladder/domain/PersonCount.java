package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.PersonCountTooLowException;

public final class PersonCount {

  public static final int MIN = 2;

  private final int personCount;

  public PersonCount(final int countOfPerson) {
    validatePersonCount(countOfPerson);
    this.personCount = countOfPerson;
  }

  private void validatePersonCount(final int countOfPerson) {
    if (countOfPerson < MIN) {
      throw new PersonCountTooLowException();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof PersonCount)) {
      return false;
    }
    PersonCount that = (PersonCount) o;
    return personCount == that.personCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(personCount);
  }
}

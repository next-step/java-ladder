package nextstep.ladder.domain;

import java.util.Objects;

public final class PersonCount {

  private final int personCount;

  public PersonCount(final int countOfPerson) {
    this.personCount = countOfPerson;
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

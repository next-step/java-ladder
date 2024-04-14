package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class People {
  private List<Person> people;
  private final int MIN_PEOPLE_NUMBER = 2;

  public People(List<Person> people) {
    validatePeople(people);
    this.people = people;
  }

  private void validatePeople(List<Person> people) {
    if (people.size() < MIN_PEOPLE_NUMBER) {
      throw new IllegalArgumentException("참여자는 최소 2명 이상이어야 합니다.");
    }
  }

  public int getPeopleNumber() {
    return people.size();
  }

  public List<String> getPeopleNames() {
    return people.stream().map(Person::getName).collect(Collectors.toList());
  }
}

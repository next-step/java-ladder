package nextstep.ladder.domain.person;

import java.util.List;

public class People {
  private List<Person> people;
  private static final int MIN_PEOPLE_NUMBER = 2;

  public People(List<Person> people) {
    validatePeople(people);
    this.people = people;
  }

  private void validatePeople(List<Person> people) {
    if (people.size() < MIN_PEOPLE_NUMBER) {
      throw new IllegalArgumentException(String.format("참여자는 최소 %d명 이상이어야 합니다.",MIN_PEOPLE_NUMBER));
    }
  }

  public int getPeopleNumber() {
    return people.size();
  }

  public Person findPersonByIndex(int index){
    return people.get(index);
  }
}

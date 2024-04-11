package nextstep.ladder.domain;

import java.util.List;

public class People {
  List<Person> people;

  public People(List<Person> people) {
    this.people = people;
  }

  public int getPeopleNumber() {
    return people.size();
  }
}

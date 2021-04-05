package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Persons {

  private final List<Person> persons;

  public Persons(List<Person> persons) {
    this.persons = persons;
  }

  public List<Person> getPersons() {
    return Collections.unmodifiableList(persons);
  }

  public int size() {
    return persons.size();
  }
}

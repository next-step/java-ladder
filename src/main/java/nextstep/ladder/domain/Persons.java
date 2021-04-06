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

  public String getName(int position) {
    return persons.get(position).getName();
  }

  public int getIndex(String name) {
    return persons.indexOf(Person.generate(name));
  }
}

package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {

  private final List<Person> persons;

  private Persons(List<Person> persons) {
    this.persons = persons;
  }

  public static Persons from(String[] names) {
    return new Persons(Arrays.stream(names)
        .map(Person::generate)
        .collect(Collectors.toList()));
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

  public boolean contains(String name) {
    return persons.contains(Person.generate(name));
  }
}

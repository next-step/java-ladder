package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

  private Persons persons;

  private Lines lines;

  private Ladder(String[] names, int height) {
    this.persons = new Persons(Arrays.stream(names).map(Person::generate).collect(Collectors.toList()));
    this.lines = new Lines(
        Stream.generate(() -> Line.generate(persons.size())).limit(height).collect(Collectors.toList()));
  }

  public static Ladder generate(String[] names, int height) {
    return new Ladder(names, height);
  }

  public List<Person> getPersons() {
    return persons.getPersons();
  }

  public List<Line> getLines() {
    return lines.getLines();
  }
}

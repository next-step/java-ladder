package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

  private List<Person> persons;

  private List<Line> lines;

  public Ladder() {
  }

  public static Ladder generate(String[] names, int height) {
    Ladder ladder = new Ladder();
    ladder.persons = Arrays.stream(names)
        .map(Person::create)
        .collect(Collectors.toList());
    ladder.lines
        = Stream.generate(() -> Line.generate(ladder.persons.size()))
        .limit(height)
        .collect(Collectors.toList());
    return ladder;
  }

  public List<Person> getPersons() {
    return persons;
  }

  public List<Line> getLines() {
    return lines;
  }
}

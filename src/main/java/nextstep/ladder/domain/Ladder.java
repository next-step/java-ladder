package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

  private static final Random RANDOM = new Random();

  private Persons persons;
  private Lines lines;

  private Ladder(String[] names, int height, LineStrategy lineStrategy) {
    this.persons = new Persons(Arrays.stream(names).map(Person::generate).collect(Collectors.toList()));
    this.lines = new Lines(
        Stream.generate(() -> Line.generate(persons.size(), lineStrategy)).limit(height).collect(Collectors.toList()));
  }

  private Ladder(String[] names, int height) {
    this(names, height, () -> RANDOM.nextBoolean());
  }

  public static Ladder generate(String[] names, int height) {
    return new Ladder(names, height);
  }

  public static Ladder generate(String[] names, int height, LineStrategy lineStrategy) {
    return new Ladder(names, height, lineStrategy);
  }

  public List<Person> getPersons() {
    return persons.getPersons();
  }

  public List<Line> getLines() {
    return lines.getLines();
  }

  public int result(String name) {
    int position = persons.getIndex(name) + 1;
    return result(position);
  }

  private int result(int start) {
    int resultPosition = lines.result(start);
    return resultPosition - 1;
  }
}

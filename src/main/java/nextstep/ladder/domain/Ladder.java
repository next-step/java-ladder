package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;

public class Ladder {

  public static final int MAX_NAME_LENGTH = 5;
  private static final Random RANDOM = new Random();

  private Persons persons;
  private Lines lines;
  private Results results;

  private Ladder(String[] names, int height, String[] results, LineStrategy lineStrategy) {
    checkInput(names, results);
    this.persons = Persons.from(names);
    this.lines = Lines.setup(names.length, height, lineStrategy);
    this.results = Results.from(results);
  }

  private static void checkInput(String[] personNames, String[] results) {
    if (personNames.length != results.length) {
      throw new IllegalArgumentException("person.size != result.size");
    }
  }

  private Ladder(String[] names, int height, String[] results) {
    this(names, height, results, () -> RANDOM.nextBoolean());
  }

  public static Ladder generate(String[] names, int height, String[] results) {
    return new Ladder(names, height, results);
  }

  public static Ladder generate(String[] names, int height, String[] results, LineStrategy lineStrategy) {
    return new Ladder(names, height, results, lineStrategy);
  }

  public List<Person> getPersons() {
    return persons.getPersons();
  }

  public List<Line> getLines() {
    return lines.getLines();
  }

  public Result result(String name) {
    if (!persons.contains(name)) {
      throw new IllegalArgumentException();
    }
    int position = persons.getIndex(name) + 1;
    return result(position);
  }

  private Result result(int start) {
    int resultPosition = lines.findFinalPosition(start) - 1;
    return results.getResult(resultPosition);
  }
}

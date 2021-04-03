package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

  private List<Person> persons;

  private int height;

  public Ladder() {
  }

  public static Ladder create(String[] names, int height) {
    Ladder ladder = new Ladder();
    ladder.persons = Arrays.stream(names)
        .map(Person::create)
        .collect(Collectors.toList());
    ladder.height = height;
    return ladder;
  }

  public int getHeight() {
    return height;
  }

  public List<Person> getPersons() {
    return persons;
  }
}

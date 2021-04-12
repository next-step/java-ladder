package nextstep.ladder.domain;

import java.util.Random;
import nextstep.ladder.DirectionStrategy;

public class LadderMatcher {

  private static final Random RANDOM = new Random();
  private Persons persons;
  private Results results;
  private Ladder ladder;

  private LadderMatcher(Persons persons, Results results, int height, DirectionStrategy directionStrategy) {
    if (persons.size() != results.size()) {
      throw new IllegalArgumentException("not matched count.");
    }
    this.ladder = Ladder.generate(persons.size(), height, directionStrategy);
    this.persons = persons;
    this.results = results;
  }

  public static LadderMatcher generate(Persons persons, Results results, int height) {
    return new LadderMatcher(persons, results, height, () -> RANDOM.nextBoolean());
  }

  public static LadderMatcher generate(Persons persons, Results results, int height, DirectionStrategy directionStrategy) {
    return new LadderMatcher(persons, results, height, directionStrategy);
  }

  public Persons getPersons() {
    return persons;
  }

  public Results getResults() {
    return results;
  }

  public Ladder getLadder() {
    return ladder;
  }

  public String findResultByPersonName(String name) {
    int startIndex = persons.findIndex(name);
    int resultIndex = ladder.move(startIndex);
    Result result = results.findResult(resultIndex);
    return result.getName();
  }
}

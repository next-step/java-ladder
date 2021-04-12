package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderMatcher {

  private Persons persons;
  private Results results;

  private LadderMatcher(Persons persons, Results results) {
    if (persons.size() != results.size()) {
      throw new IllegalArgumentException("not matched count.");
    }
    this.persons = persons;
    this.results = results;
  }

  public static LadderMatcher generate(Persons persons, Results results) {
    return new LadderMatcher(persons, results);
  }

  public Persons getPersons() {
    return persons;
  }

  public Results getResults() {
    return results;
  }

  public Map<String, String> getMoveResult(Ladder ladder) {
    List<String> keys = persons.getPersons().stream()
        .map(Person::getName)
        .collect(Collectors.toList());

    int size = persons.size();
    List<String> values = IntStream.range(0, size)
        .mapToObj(index -> {
          int resultIndex = ladder.move(index);
          return results.findResult(resultIndex);
        })
        .map(Result::getName)
        .collect(Collectors.toList());

    Map<String, String> moveResult = new HashMap<>();
    IntStream.range(0, size).forEach(i -> moveResult.put(keys.get(i), values.get(i)));
    return moveResult;
  }
}

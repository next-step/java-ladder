package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import nextstep.ladder.exception.PersonNotFoundException;

public final class GameResults {

  private final Map<Person, Result> gameResults;

  public GameResults() {
    this(new HashMap<>());
  }

  public GameResults(Map<Person, Result> gameResults) {
    this.gameResults = gameResults;
  }

  public Map<Person, Result> allResults() {
    return Collections.unmodifiableMap(gameResults);
  }

  public Result resultOf(String personName) {
    final Person person = Person.valueOf(personName);

    validatePersonExists(person);

    return gameResults.get(person);
  }

  private void validatePersonExists(Person person) {
    if (!gameResults.containsKey(person)) {
      throw new PersonNotFoundException(person);
    }
  }

  public int size() {
    return gameResults.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameResults that = (GameResults) o;
    return Objects.equals(gameResults, that.gameResults);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gameResults);
  }
}

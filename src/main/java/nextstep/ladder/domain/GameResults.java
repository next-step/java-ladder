package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class GameResults {

  private final Map<Person, Result> gameResults;

  public GameResults() {
    this(new HashMap<>());
  }

  public GameResults(Map<Person, Result> gameResults) {
    this.gameResults = gameResults;
  }

  public Map<Person, Result> allResults() {
    return null;
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

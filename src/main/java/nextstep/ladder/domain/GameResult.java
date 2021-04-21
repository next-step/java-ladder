package nextstep.ladder.domain;

import java.util.Objects;

public final class GameResult {

  private final Person person;
  private final Result result;

  private GameResult(Person person, Result result) {
    this.person = person;
    this.result = result;
  }

  public static GameResult of(Person person, Result result) {
    return new GameResult(person, result);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameResult that = (GameResult) o;
    return Objects.equals(person, that.person) && Objects.equals(result, that.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(person, result);
  }
}

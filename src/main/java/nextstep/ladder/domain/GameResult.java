package nextstep.ladder.domain;

public final class GameResult {

  private GameResult(Person person, Result result) {

  }

  public static GameResult of(Person person, Result result) {
    return new GameResult(person, result);
  }
}

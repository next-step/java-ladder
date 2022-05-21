package ladder.domain;

import java.security.InvalidParameterException;
import java.util.Objects;

public class GameResult {

  public static final String INVALID_GAME_RESULT_MSG = "게임 결과는 비어있을 수 없습니다.";
  private final String result;

  private GameResult(String result) {
    assertGameResult(result);
    this.result = result;
  }

  public static GameResult from(String result) {
    return new GameResult(result);
  }

  private void assertGameResult(String result) {
    if (result == null || result.isBlank()) {
      throw new InvalidParameterException(INVALID_GAME_RESULT_MSG);
    }
  }

  public String getResult() {
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof GameResult)) {
      return false;
    }
    GameResult that = (GameResult) o;
    return Objects.equals(result, that.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }
}

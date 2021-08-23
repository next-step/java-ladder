package ladderGame.step4.model;

import java.util.Objects;

public class MatchResult {

  private static final int LIMIT_INDEX = 0;
  private static final String MSG_ERROR_INVALID_INDEX = "인덱스값은 0 미만일 수 없습니다.";
  private static final String MSG_ERROR_INVALID_NAME = "검색할 사용자명은 빈 값일 수 없습니다.";

  private final String playerName;

  private final int index;

  private MatchResult(final String playerName, final int index) {
    validationData(playerName, index);
    this.playerName = playerName;
    this.index = index;
  }

  private void validationData(final String playerName, final int index) {
    invalidName(playerName);
    invalidIndex(index);
  }

  private void invalidName(final String playerName) {
    if (playerName == null || playerName.isEmpty()) {
      throw new IllegalArgumentException(MSG_ERROR_INVALID_NAME);
    }
  }

  private void invalidIndex(final int index) {
    if (index < LIMIT_INDEX) {
      throw new IllegalArgumentException(MSG_ERROR_INVALID_INDEX);
    }
  }

  public static MatchResult createMatchResult(final String playerName, final int index) {
    return new MatchResult(playerName, index);
  }

  public String getPlayerName() {
    return playerName;
  }

  public int getIndex() {
    return index;
  }

  public boolean isMatchName(String findName) {
    return playerName.equals(findName);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final MatchResult that = (MatchResult) o;
    return index == that.index && Objects.equals(playerName, that.playerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerName, index);
  }
}
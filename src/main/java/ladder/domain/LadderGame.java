package ladder.domain;

import java.security.InvalidParameterException;
import ladder.domain.strategy.LadderConnectStrategy;

public class LadderGame {

  public static final String NOT_SAME_USER_RESULT_COUNT_MSG = "게임 참여자 개수와 게임 결과 개수는 동일해야 합니다.";
  private final Ladder ladder;
  private final GameUsers userNames;
  private final GameResults gameResults;

  private LadderGame(Ladder ladder, GameUsers userNames, GameResults gameResults) {
    assertLadderGame(userNames, gameResults);
    this.ladder = ladder;
    this.userNames = userNames;
    this.gameResults = gameResults;
  }

  public static LadderGame of(GameUsers gameUsers, GameResults gameResults, int ladderHeight,
      LadderConnectStrategy ladderConnectStrategy) {
    return new LadderGame(Ladder.of(ladderHeight, ladderConnectStrategy), gameUsers, gameResults);
  }

  public int getLadderHeight() {
    return this.ladder.getLadderHeight();
  }

  public Ladder getLadder() {
    return ladder;
  }

  public GameUsers getUserNames() {
    return userNames;
  }

  public int getLadderWidth() {
    return ladder.getLadderWidth();
  }

  private void assertLadderGame(GameUsers userNames, GameResults gameResults) {
    if (userNames.getUserSize() != gameResults.getResultSize()) {
      throw new InvalidParameterException(NOT_SAME_USER_RESULT_COUNT_MSG);
    }
  }
}

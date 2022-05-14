package ladder.domain;

import java.security.InvalidParameterException;
import java.util.stream.Collectors;
import ladder.domain.strategy.LadderConnectStrategy;

public class LadderGame {

  public static final String NOT_SAME_USER_RESULT_COUNT_MSG = "게임 참여자 개수와 게임 결과 개수는 동일해야 합니다.";
  private final Ladder ladder;
  private final GameUsers gameUsers;
  private final GameResults gameResults;

  private LadderGame(Ladder ladder, GameUsers gameUsers, GameResults gameResults) {
    assertLadderGame(gameUsers, gameResults);
    this.ladder = ladder;
    this.gameUsers = gameUsers;
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

  public GameUsers getGameUsers() {
    return gameUsers;
  }

  public int getLadderWidth() {
    return ladder.getLadderWidth();
  }

  public GameResults getGameResults() {
    return gameResults;
  }

  public GameResult gameResult(GameUser gameUser) {
    int height = 0;
    int width = gameUsers.getUserIdx(gameUser);

    while (height < ladder.getLadderHeight()) {
      width = getNextWidth(ladder, height, width);
      height++;
    }

    return gameResults.getGameResult(width);
  }

  public GameResults gameResultAll() {
    return GameResults.from(gameUsers.getValues().stream()
        .map(gameUser -> gameResult(gameUser))
        .collect(Collectors.toList()));
  }

  private int getNextWidth(Ladder ladder, int height, int width) {
    if (ladder.isLeftConnect(height, width)) {
      return --width;
    }
    if (ladder.isRightConnect(height, width)) {
      return ++width;
    }
    return width;
  }

  private void assertLadderGame(GameUsers userNames, GameResults gameResults) {
    if (userNames.getUserSize() != gameResults.getResultSize()) {
      throw new InvalidParameterException(NOT_SAME_USER_RESULT_COUNT_MSG);
    }
  }

}

package ladder.domain;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.strategy.ConnectStrategy;
import ladder.domain.strategy.RandomConnectStrategy;

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

  private void assertLadderGame(GameUsers userNames, GameResults gameResults) {
    if (userNames.getUserSize() != gameResults.getResultSize()) {
      throw new InvalidParameterException(NOT_SAME_USER_RESULT_COUNT_MSG);
    }
  }

  public static LadderGame of(String gameUserNames, String gameResults, int ladderHeight) {
    GameUsers gameUsers = GameUsers.from(gameUserNames);
    GameResults results = GameResults.from(gameResults);

    List<ConnectStrategy> connectStrategies = IntStream.range(0, ladderHeight)
        .mapToObj(i -> new RandomConnectStrategy(gameUsers.getUserSize()))
        .collect(Collectors.toList());

    return new LadderGame(Ladder.of(connectStrategies), gameUsers, results);
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
}

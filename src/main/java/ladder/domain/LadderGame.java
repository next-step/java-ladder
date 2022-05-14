package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.strategy.ConnectStrategy;
import ladder.domain.strategy.RandomConnectStrategy;

public class LadderGame {

  private final Ladder ladder;
  private final GameUsers userNames;

  private LadderGame(Ladder ladder, GameUsers userNames) {
    this.ladder = ladder;
    this.userNames = userNames;
  }

  public static LadderGame of(String gameUserNames, int ladderHeight) {
    GameUsers gameUsers = GameUsers.from(gameUserNames);
    List<ConnectStrategy> connectStrategies = IntStream.range(0, ladderHeight)
        .mapToObj(i -> new RandomConnectStrategy(gameUsers.getUserSize()))
        .collect(Collectors.toList());

    return new LadderGame(Ladder.of(connectStrategies), gameUsers);
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

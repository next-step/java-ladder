package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.strategy.ConnectStrategy;
import ladder.domain.strategy.RandomConnectStrategy;

public class LadderGame {

  private final Ladder ladder;
  private final UserNames userNames;

  private LadderGame(Ladder ladder, UserNames userNames) {
    this.ladder = ladder;
    this.userNames = userNames;
  }

  public static LadderGame of(UserNames gameUserNames, int ladderHeight) {
    List<ConnectStrategy> connectStrategies = IntStream.range(0, ladderHeight)
        .mapToObj(i -> new RandomConnectStrategy(gameUserNames.getUserSize()))
        .collect(Collectors.toList());

    return new LadderGame(Ladder.of(connectStrategies), gameUserNames);
  }

  public int getLadderHeight() {
    return this.ladder.getLadderHeight();
  }

  public Ladder getLadder() {
    return ladder;
  }

  public UserNames getUserNames() {
    return userNames;
  }

  public int getLadderWidth() {
    return ladder.getLadderWidth();
  }
}

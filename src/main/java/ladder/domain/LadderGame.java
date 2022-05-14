package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.strategy.ConnectStrategy;
import ladder.domain.strategy.RandomConnectStrategy;

public class LadderGame {

  private final Ladder ladder;
  private final UserNames userNames;

  private LadderGame(Ladder ladder, UserNames userNames) {
    this.ladder = ladder;
    this.userNames = userNames;
  }

  public static LadderGame of(String gameUserNames, int height) {
    UserNames userNames = UserNames.from(gameUserNames);
    List<ConnectStrategy> connectStrategies = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      connectStrategies.add(new RandomConnectStrategy(userNames.getUserSize()));
    }
    Ladder ladder = Ladder.of(userNames.getUserSize(), connectStrategies);

    return new LadderGame(ladder, userNames);
  }

  public int getUserSize() {
    return this.userNames.getUserSize();
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
}

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

  public static LadderGame of(UserNames userNames, int height) {
    List<ConnectStrategy> connectStrategies = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      connectStrategies.add(new RandomConnectStrategy());
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
}
